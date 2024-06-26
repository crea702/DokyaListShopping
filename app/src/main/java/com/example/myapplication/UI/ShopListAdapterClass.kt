package com.example.myapplication.UI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.ShopElement

class ShopListAdapterClass : RecyclerView.Adapter<ShopListAdapterClass.ShopElementViewHolder>() {

    val list = listOf<ShopElement>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopElementViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_disabled, parent, false)
        return ShopElementViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewHoler: ShopElementViewHolder, position: Int) {
        val shopElement14 = list[position]

        viewHoler.tvName.text = shopElement14.name
        viewHoler.tvCount.text = shopElement14.count.toString()

        viewHoler.view.setOnLongClickListener {
            true
        }
    }

    class ShopElementViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }
}