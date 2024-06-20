package com.example.myapplication.data

import com.example.myapplication.domain.ShopElement
import com.example.myapplication.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository{
    private var shopList = mutableListOf<ShopElement>()

    private var autoIncrementId = 0

    override fun addShopElement(shopElement: ShopElement) {
        if (shopElement.id == ShopElement.UNDEFINED_ID){
            shopElement.id = autoIncrementId
            autoIncrementId++
        }

        shopList.add(shopElement)
    }

    override fun deleteShopElement(shopElement: ShopElement) {
        shopList.remove(shopElement)

    }

    override fun editShopElement(shopElement: ShopElement) {
        val oldElement = getShopElement(shopElement.id)
        shopList.remove(oldElement)
        addShopElement(shopElement)
    }

    override fun getShopElement(shopElementId: Int): ShopElement {
        return shopList.find {
            it.id == shopElementId
        } ?: throw RuntimeException("Element with id $shopElementId not found")
    }

    override fun getShopList(): List<ShopElement> {
        return shopList.toList()
    }
}