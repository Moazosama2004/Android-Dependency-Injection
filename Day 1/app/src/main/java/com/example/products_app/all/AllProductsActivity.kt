package com.example.products_app.all

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.products_app.all.manager.AllProductsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AllProductsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel = hiltViewModel<AllProductsViewModel>()

            AllProductsScreen(viewModel)
        }
    }
}
