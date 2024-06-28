package com.example.myapplication.domain

class DeleteShopElementUseCase (private val shopListRepository: ShopListRepository){

    fun deleteShopElement(shopElement: ShopElement) {
        shopListRepository.deleteShopElement(shopElement)
    }
}