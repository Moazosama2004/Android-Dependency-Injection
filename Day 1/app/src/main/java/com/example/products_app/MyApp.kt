package com.example.products_app

import android.app.Application
import com.example.products_app.services.ServiceLocator

class MyApp : Application() {
    lateinit var serviceLocator: ServiceLocator
        private set

    override fun onCreate() {
        super.onCreate()
        serviceLocator = ServiceLocator(this)
    }
}