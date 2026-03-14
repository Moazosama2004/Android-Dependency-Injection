package com.example.products_app.di

import android.app.Application
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.data.db.ProductsDataBase
import com.example.products_app.data.local.ProductsDao
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductService
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(
    private val application: Application
) {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val dao: ProductsDao by lazy { ProductsDataBase.getInstance(application).getProductsDao() }
    val productsService: ProductService by lazy { retrofit.create(ProductService::class.java) }

    val localDataSource by lazy { ProductsLocalDataSource(dao) }
    val remoteDataSource by lazy { ProductsRemoteDataSourceImpl(productsService) }
    val repo by lazy {
        ProductsRepositoryImpl.getInstance(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )
    }


}