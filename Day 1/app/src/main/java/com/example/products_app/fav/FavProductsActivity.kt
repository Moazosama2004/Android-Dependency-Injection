package com.example.products_app.fav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.products_app.fav.manager.FavProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            val viewModel = hiltViewModel<FavProductsViewModel>()
            FavProductsScreen(viewModel)
        }
    }
}

