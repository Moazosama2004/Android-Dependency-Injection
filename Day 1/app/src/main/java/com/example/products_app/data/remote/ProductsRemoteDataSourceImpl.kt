package com.example.products_app.data.remote

import com.example.products_app.data.model.Product
import com.example.products_app.services.ServiceLocator

class ProductsRemoteDataSourceImpl(
    private val serviceLocator: ServiceLocator
) : RemoteDataSource {

    private val productsService : ProductService = serviceLocator.provideProductsService()

    override suspend fun getAllProducts(): List<Product>?{
        try {
            return productsService.getAllProducts().body()?.products
        }catch (th: Throwable){
            throw th
        }
    }
}