package com.example.myapplication.UI

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var count1 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this){
            Log.d("MainActivityTest", it.toString())
            if (count1 == 0) {
                count1++
                val item = it[0]
                viewModel.changeEnabledState(item)
            }


        }

    }
}