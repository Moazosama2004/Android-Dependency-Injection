package com.example.products_app.fav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.all.manager.AllProductsViewModel
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.fav.manager.FavProductFactory
import com.example.products_app.fav.manager.FavProductsViewModel
import org.koin.androidx.compose.koinViewModel

class FavProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            val viewModel = koinViewModel<FavProductsViewModel>()
            FavProductsScreen(viewModel)
        }
    }
}

