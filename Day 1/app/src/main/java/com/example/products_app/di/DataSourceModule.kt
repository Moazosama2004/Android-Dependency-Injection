package com.example.products_app.di

import com.example.products_app.data.local.LocalDataSource
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductsRemoteDataSource
import com.example.products_app.data.remote.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindLocalDataSource(localDataSource: ProductsLocalDataSource) : LocalDataSource

    @Binds
    fun bindRemoteDataSource(remoteDataSource: ProductsRemoteDataSource) : RemoteDataSource
}