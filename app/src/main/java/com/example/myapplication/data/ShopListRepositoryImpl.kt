package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.domain.ShopElement
import com.example.myapplication.domain.ShopListRepository
import kotlin.random.Random

object ShopListRepositoryImpl: ShopListRepository{
    private var shopList = sortedSetOf<ShopElement>({ p0, p1 -> p0.id.compareTo(p1.id) })


    private val shopListLD = MutableLiveData<List<ShopElement>>()
    private var autoIncrementId = 0

    init {
        for (i in 1..1015) {
            val item = ShopElement("Name $i", i, Random.nextBoolean())
            addShopElement(item)
        }
    }

    override fun addShopElement(shopElement: ShopElement) {
        if (shopElement.id == ShopElement.UNDEFINED_ID){
            shopElement.id = autoIncrementId
            autoIncrementId++
        }

        shopList.add(shopElement)
        updateList()
    }

    override fun deleteShopElement(shopElement: ShopElement) {
        shopList.remove(shopElement)
        updateList()

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

    override fun getShopList(): LiveData<List<ShopElement>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}