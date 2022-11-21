package com.example.ui_example.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui_example.R
import kotlinx.android.synthetic.main.activity_simple_recycler.*

class SimpleRecyclerViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_simple_recycler)

        setupUI()
    }

    private fun setupUI() {
        setupAdapter()
    }

    private fun setupAdapter() {
        val titleList = listOf("title1", "title2", "title3", "title4", "title5", "title6", "title7", "title8")
        val adapter = SimpleRecyclerAdapter()
        simpleRecyclerView.adapter = adapter
        simpleRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter.differ.submitList(titleList)

        // add separate cell decoration
        val separate = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        simpleRecyclerView.addItemDecoration(separate)
    }
}