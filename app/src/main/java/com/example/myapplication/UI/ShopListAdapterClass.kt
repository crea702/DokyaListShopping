package com.example.myapplication.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.myapplication.R
import com.example.myapplication.domain.ShopElement

class ShopListAdapterClass :ListAdapter<ShopElement, ShopElementViewHolder> (ShopItemDiffCallback()){

    var onShopElementLongClickListener: ((ShopElement) -> Unit)? = null

    var onShopElementOnClickListener: ((ShopElement) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopElementViewHolder {

        val layout = when (viewType) {
            VIEW_TYPE_ENABLED-> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED->R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopElementViewHolder(view)
    }

    override fun onBindViewHolder(viewHoler: ShopElementViewHolder, position: Int) {
        val shopElement14 = getItem(position)
        viewHoler.view.setOnLongClickListener {
            onShopElementLongClickListener?.invoke(shopElement14)
            true
        }

        viewHoler.view.setOnClickListener{
            onShopElementOnClickListener?.invoke(shopElement14)
        }

            viewHoler.tvName.text = shopElement14.name
            viewHoler.tvCount.text = shopElement14.count.toString()
    }


    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101

        const val MAX_POOL_SIZE = 15
    }

}