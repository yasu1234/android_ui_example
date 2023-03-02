package com.example.ui_example.layout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.databinding.ActivityTabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayoutActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTabLayoutBinding
    private lateinit var adapter: TabLayoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        setupTabLayout()
    }

    private fun setupTabLayout() {
        adapter = TabLayoutAdapter(this)
        binding.tabLayoutPager.adapter = adapter

        TabLayoutMediator(indicator, tabLayoutPager) { tab, position ->
            if (position == 0) {
                tab.text = "First Tab"
            } else {
                tab.text = "Second Tab"
            }
        }.attach()
    }
}