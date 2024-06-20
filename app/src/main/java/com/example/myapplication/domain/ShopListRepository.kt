package com.example.myapplication.domain

interface ShopListRepository {

    fun addShopElement(shopElement: ShopElement)

    fun deleteShopElement(shopElement: ShopElement)

    fun editShopElement(shopElement: ShopElement)

    fun getShopElement(shopElementId: Int): ShopElement

    fun getShopList():List<ShopElement>
}