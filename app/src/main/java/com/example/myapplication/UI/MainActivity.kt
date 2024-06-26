package com.example.myapplication.UI

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

import com.example.myapplication.R
import com.example.myapplication.domain.ShopElement

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var llShopList: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llShopList = findViewById(R.id.ll_shop_list)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            showList(it)
            }
        }



    private fun showList(list: List<ShopElement>) {
        llShopList.removeAllViews()
        for (shopElement14 in list) {
            val layoutId = if (shopElement14.enabled) {
                R.layout.item_shop_enabled
            } else {
                R.layout.item_shop_disabled
            }
            val view = LayoutInflater.from(this).inflate(layoutId, llShopList, false)
            val tvName = view.findViewById<TextView>(R.id.tv_name)
            val tvCount = view.findViewById<TextView>(R.id.tv_count)
            tvName.text = shopElement14.name
            tvCount.text = shopElement14.count.toString()

            view.setOnLongClickListener{
                viewModel.changeEnabledState(shopElement14)
                true
            }

            llShopList.addView(view)
        }
    }
}