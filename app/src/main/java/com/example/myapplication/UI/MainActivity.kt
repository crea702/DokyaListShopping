package com.example.myapplication.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var shopListadapter: ShopListAdapterClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            shopListadapter.shopList1 = it

        }
    }

    private fun setupRecyclerView() {
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        shopListadapter = ShopListAdapterClass()
        with(rvShopList) {
            adapter = shopListadapter
            recycledViewPool.setMaxRecycledViews(ShopListAdapterClass.VIEW_TYPE_ENABLED, ShopListAdapterClass.MAX_POOL_SIZE)
            recycledViewPool.setMaxRecycledViews(ShopListAdapterClass.VIEW_TYPE_DISABLED, ShopListAdapterClass.MAX_POOL_SIZE)
        }

    }

}