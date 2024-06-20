package com.example.myapplication.domain

class EditShopElementUseCase (private val shopListRepository: ShopListRepository){

    fun editShopElement(shopElement: ShopElement) {
        shopListRepository.editShopElement(shopElement)
    }
}