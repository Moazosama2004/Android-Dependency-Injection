package com.example.products_app.di

import androidx.room.Room
import com.example.di_starterapplication.data.repository.ProductsRepository
import com.example.di_starterapplication.data.repository.ProductsRepositoryImpl
import com.example.products_app.all.manager.AllProductsViewModel
import com.example.products_app.data.local.LocalDataSource
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.local.ProductsLocalDataSource
import com.example.products_app.data.remote.ProductService
import com.example.products_app.data.remote.ProductsRemoteDataSourceImpl
import com.example.products_app.data.remote.RemoteDataSource
import com.example.products_app.fav.manager.FavProductsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    // all dependencies that we need
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ProductsDataBase> {
        Room.databaseBuilder(
            androidContext(),
            ProductsDataBase::class.java,
            "roomdb"
        ).build()
    }

    single {
        val retrofit = get<Retrofit>()
        retrofit.create(ProductService::class.java)
    }

    single {
        val database = get<ProductsDataBase>()
        database.getProductsDao()
    }

    factory<RemoteDataSource> { ProductsRemoteDataSourceImpl(get()) }
    factory<LocalDataSource> { ProductsLocalDataSource(get()) }
    factory<ProductsRepository> { ProductsRepositoryImpl.getInstance(get(), get()) }

    viewModel<AllProductsViewModel> { AllProductsViewModel(get()) }
    viewModel<FavProductsViewModel> { FavProductsViewModel(get()) }
}