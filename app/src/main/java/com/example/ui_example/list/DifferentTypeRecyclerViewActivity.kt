package com.example.ui_example.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui_example.databinding.ActivityDifferentTypeRecyclerViewBinding

class DifferentTypeRecyclerViewActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDifferentTypeRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDifferentTypeRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        val items = mutableListOf(ItemType.Hoge, ItemType.Fuga, ItemType.Piyo)
        val adapter = DifferentTypeRecyclerAdapter(this, items)

        binding.differentTypeRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.differentTypeRecyclerView.adapter = adapter

        adapter.setOnItemListener(object: DifferentTypeRecyclerAdapter.OnItemListener {
            override fun onNextButtonPushed() {
            }
        })
    }
}