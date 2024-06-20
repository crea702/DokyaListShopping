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

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopElement(shopElement: ShopElement) {
        deleteShopElementUseCase.deleteShopElement(shopElement)
    }

    fun changeEnabledState(shopElement: ShopElement) {
        val newItem = shopElement.copy(enabled = !shopElement.enabled)
        editShopElementUseCase.editShopElement(newItem)

    }

}