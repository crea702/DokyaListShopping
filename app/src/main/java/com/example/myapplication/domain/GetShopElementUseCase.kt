package com.example.myapplication.domain

class GetShopElementUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopElement(shopElementId: Int): ShopElement {
        return shopListRepository.getShopElement(shopElementId)
    }
}