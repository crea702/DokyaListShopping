package com.example.myapplication.UI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ShopListRepositoryImpl
import com.example.myapplication.domain.DeleteShopElementUseCase
import com.example.myapplication.domain.EditShopElementUseCase

import com.example.myapplication.domain.GetShopListUseCase
import com.example.myapplication.domain.ShopElement

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopElementUseCase = DeleteShopElementUseCase(repository)
    private val editShopElementUseCase = EditShopElementUseCase(repository)

    val shopList = MutableLiveData<List<ShopElement>>()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
        shopList.value = list
    }
}