package com.example.myapplication.domain

class AddShopElementUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopElement(shopElement: ShopElement) {
        shopListRepository.addShopElement(shopElement)
    }
}