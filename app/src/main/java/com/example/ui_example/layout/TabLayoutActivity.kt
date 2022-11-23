package com.example.ui_example.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity: AppCompatActivity() {
    private lateinit var adapter: TabLayoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tab_layout)

        setupUI()
    }

    private fun setupUI() {
        setupTabLayout()
    }

    private fun setupTabLayout() {
        adapter = TabLayoutAdapter(this)
        tabLayoutPager.adapter = adapter

        TabLayoutMediator(indicator, tabLayoutPager) { tab, position ->
            if (position == 0) {
                tab.text = "First Tab"
            } else {
                tab.text = "Second Tab"
            }
        }.attach()
    }
}