package com.example.products_app.di

import android.app.Application
import androidx.room.Room
import com.example.products_app.data.local.ProductsDao
import com.example.products_app.data.local.ProductsDataBase
import com.example.products_app.data.remote.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Provides
    fun provideProductService(retrofit: Retrofit): ProductService {
        return retrofit.create(ProductService::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsDatabase(application: Application): ProductsDataBase {
        return Room.databaseBuilder(
            application,
            ProductsDataBase::class.java,
            "roomdb").build()
    }

    @Provides
    fun provideProductsDao(db : ProductsDataBase) : ProductsDao = db.getProductsDao()
}