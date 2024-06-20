package com.example.myapplication.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addShopElement(shopElement: ShopElement)

    fun deleteShopElement(shopElement: ShopElement)

    fun editShopElement(shopElement: ShopElement)

    fun getShopElement(shopElementId: Int): ShopElement

    fun getShopList():LiveData<List<ShopElement>>
}