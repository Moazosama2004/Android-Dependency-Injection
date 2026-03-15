package com.example.products_app

import android.app.Application
import com.example.products_app.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(dataModule)
        }
    }
}