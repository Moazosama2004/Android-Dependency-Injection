package com.example.products_app.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.products_app.data.model.Product

@Database(entities = [Product::class], version = 1)
abstract class ProductsDataBase : RoomDatabase(){
    abstract fun getProductsDao(): ProductsDao
}