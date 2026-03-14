package com.example.products_app.all

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.MyApp
import com.example.products_app.all.manager.AllProductFactory
import com.example.products_app.all.manager.AllProductsViewModel
import com.example.products_app.data.db.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RetrofitHelper
import com.example.products_app.fav.manager.FavProductFactory
import com.example.products_app.fav.manager.FavProductsViewModel

class AllProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val appContainer = (application as MyApp).appContainer
           val factory = AllProductFactory(appContainer.repo)
            val viewModel = viewModel<AllProductsViewModel>(factory = factory)


            AllProductsScreen(viewModel)
        }
    }
}
