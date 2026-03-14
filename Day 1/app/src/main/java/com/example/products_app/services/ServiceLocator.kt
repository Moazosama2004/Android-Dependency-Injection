package com.example.products_app.services

import android.app.Application
import com.example.di_starterapplication.data.repository.ProductsRepository
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.data.local.ProductsDao
import com.example.products_app.data.db.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductService
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RemoteDataSource
import com.example.products_app.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceLocator(
    private val application: Application
) {

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Daos
    fun provideProductsDao() : ProductsDao = ProductsDataBase.getInstance(application).getProductsDao()

    // network services
    fun provideProductsService() : ProductService = retrofit.create(ProductService::class.java)

    // data-sources
    fun provideProductsRemoteDataSource() : RemoteDataSource = ProductsRemoteDataSourceImpl(this)
    fun provideProductsLocalDataSource() : ProductsLocalDataSource = ProductsLocalDataSource(this)

    // view-models
    fun provideProductsRepository() : ProductsRepository = ProductsRepositoryImpl.getInstance(this)


}