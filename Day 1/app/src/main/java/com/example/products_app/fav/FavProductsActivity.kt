package com.example.products_app.fav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.MyApp
import com.example.products_app.data.db.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.fav.manager.FavProductsViewModel
import com.example.products_app.fav.manager.FavProductsViewModelFactory

class FavProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            val serviceLocator = (application as MyApp).serviceLocator
            val factory = FavProductsViewModelFactory(serviceLocator)
            val viewModel = viewModel<FavProductsViewModel>(factory = factory)

            FavProductsScreen(viewModel)
        }
    }
}

