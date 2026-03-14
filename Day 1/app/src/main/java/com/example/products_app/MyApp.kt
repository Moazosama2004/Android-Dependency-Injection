package com.example.products_app

import android.app.Application
import com.example.products_app.di.AppContainer

class MyApp : Application() {
    lateinit var appContainer: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(this)
    }
}