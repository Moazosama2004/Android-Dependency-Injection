package com.example.products_app.fav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.MyApp
import com.example.products_app.all.manager.AllProductFactory
import com.example.products_app.data.db.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.fav.manager.FavProductFactory
import com.example.products_app.fav.manager.FavProductsViewModel

class FavProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            val appContainer = (application as MyApp).appContainer
            val factory = FavProductFactory(appContainer.repo)
            val viewModel = viewModel<FavProductsViewModel>(factory = factory)

            FavProductsScreen(viewModel)
        }
    }
}

