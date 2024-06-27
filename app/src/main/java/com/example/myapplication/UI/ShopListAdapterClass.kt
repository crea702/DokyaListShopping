package com.example.myapplication.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.ShopElement

class ShopListAdapterClass : RecyclerView.Adapter<ShopListAdapterClass.ShopElementViewHolder>() {

    var shopList1 = listOf<ShopElement>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopElementViewHolder {

        val layout = when (viewType) {
            VIEW_TYPE_ENABLED-> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED->R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopElementViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shopList1.size
    }

    override fun onBindViewHolder(viewHoler: ShopElementViewHolder, position: Int) {
        val shopElement14 = shopList1[position]
        viewHoler.view.setOnLongClickListener {
            true
        }
            viewHoler.tvName.text = shopElement14.name
            viewHoler.tvCount.text = shopElement14.count.toString()
    }

    override fun onViewRecycled(viewHoler: ShopElementViewHolder) {
        super.onViewRecycled(viewHoler)
        viewHoler.tvName.text = ""
        viewHoler.tvCount.text = ""
        viewHoler.tvName.setTextColor(ContextCompat.getColor(viewHoler.view.context, android.R.color.white))
    }

    override fun getItemViewType(position: Int): Int {
        val item = shopList1[position]
        return if (item.enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }

    class ShopElementViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    companion object {
        const val VIEW_TYPE_ENABLED = 100
        const val VIEW_TYPE_DISABLED = 101

        const val MAX_POOL_SIZE = 15
    }
}