package com.example.myapplication.UI

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.domain.ShopElement

class ShopItemDiffCallback: DiffUtil.ItemCallback<ShopElement> (){
    override fun areItemsTheSame(oldItem: ShopElement, newItem: ShopElement): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopElement, newItem: ShopElement): Boolean {
        return oldItem == newItem
    }
}