package com.example.myapplication.domain

class GetShopListUseCase (private val shopListRepository: ShopListRepository){

    fun getShopList(): List<ShopElement> {
        return shopListRepository.getShopList()
    }
}