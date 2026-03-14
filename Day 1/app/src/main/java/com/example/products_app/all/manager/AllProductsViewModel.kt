package com.example.products_app.all.manager

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.products_app.data.model.Product
import com.example.di_starterapplication.data.repository.ProductsRepository
import com.example.products_app.services.ServiceLocator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllProductsViewModel(
    private val serviceLocator: ServiceLocator
): ViewModel() {

    private val repository: ProductsRepository = serviceLocator.provideProductsRepository()
    private val mutableMessage : MutableLiveData<String?> = MutableLiveData("")
    val message : LiveData<String?> = mutableMessage

    private val mutableProducts : MutableLiveData<List<Product>?> = MutableLiveData()
    val products : LiveData<List<Product>?> = mutableProducts

    init {
        Log.i("TAG", "ViewModel: Initializer")
    }

    fun getProducts(){
        viewModelScope.launch (Dispatchers.IO){
            try {
                val list = repository.getAllProducts(true)
                if(!list.isNullOrEmpty()){
                    mutableProducts.postValue(list)
                }else{
                    mutableMessage.postValue("Couldn't Load Data")
                }
            }catch (ex: Exception){
                mutableMessage.postValue(ex.message)
            }
        }
    }

    fun addProduct(product: Product?){
        if(product != null){
            viewModelScope.launch {
                try {
                    val res = repository.addProduct(product)
                    if(res>0)
                        mutableMessage.postValue("${product.title} is added to favorite")
                    else
                        mutableMessage.postValue("${product.title} is already in favorites")

                }catch (ex:Exception){
                    mutableMessage.postValue(ex.message)
                }
            }
        }else{
            mutableMessage.postValue("Couldn't be added to Favorites")
        }
    }

}
@Suppress("UNCHECKED_CAST")
class AllProductFactory(private val serviceLocator: ServiceLocator): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AllProductsViewModel(serviceLocator) as T
    }
}