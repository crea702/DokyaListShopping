package com.example.myapplication.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ShopListRepositoryImpl
import com.example.myapplication.domain.AddShopElementUseCase
import com.example.myapplication.domain.EditShopElementUseCase
import com.example.myapplication.domain.GetShopElementUseCase
import com.example.myapplication.domain.ShopElement

class ShopElementViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopElementUseCase = GetShopElementUseCase(repository)
    private val addShopElementUseCase = AddShopElementUseCase(repository)
    private val editShopElementUseCase = EditShopElementUseCase(repository)

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shopElement = MutableLiveData<ShopElement>()
    val shopElement: LiveData<ShopElement>
        get() = _shopElement

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun getShopElement(shopElementId: Int) {
        val item = getShopElementUseCase.getShopElement(shopElementId)
        _shopElement.value = item
    }

    fun addShopElement(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            val shopElement = ShopElement(name, count, true)
            addShopElementUseCase.addShopElement(shopElement)
            finishWork()
        }
    }

    fun editShopElement(inputName: String?, inputCount: String?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            _shopElement.value?.let {
                val item = it.copy(name = name, count = count)
                editShopElementUseCase.editShopElement(item)
                finishWork()
            }

        }
    }

    private fun parseName(inputName: String?) : String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?) : Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e : Exception){
            0
        }
    }

    private fun validateInput(name: String, count: Int): Boolean{
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (count <= 0) {
            _errorInputCount.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInputName.value = false
    }

    fun resetErrorInputCount() {
        _errorInputCount.value = false
    }
    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }
}