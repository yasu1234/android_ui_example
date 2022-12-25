package com.example.ui_example.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui_example.R
import com.example.ui_example.widget.SwipeHelper
import kotlinx.android.synthetic.main.activity_simple_recycler.*

class SimpleRecyclerViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_simple_recycler)

        setupUI()
    }

    private fun setupUI() {
        setupActionBar()
        setupAdapter()
    }

    private fun setupActionBar() {
        supportActionBar?.title = "RecyclerView"
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

        val itemTouchHelper = ItemTouchHelper(object : SwipeHelper(simpleRecyclerView) {
            override fun instantiateUnderlayButton(position: Int): List<UnderlayButton> {
                var buttons = listOf<UnderlayButton>()
                val deleteButton = deleteButton(position)
                when (position) {
                    0 -> buttons = listOf(deleteButton)
                    else -> Unit
                }
                return buttons
            }
        })

        itemTouchHelper.attachToRecyclerView(simpleRecyclerView)
    }

    private fun deleteButton(position: Int) : SwipeHelper.UnderlayButton {
        return SwipeHelper.UnderlayButton(
            this,
            "Delete",
            14.0f,
            android.R.color.holo_red_light,
            object : SwipeHelper.UnderlayButtonClickListener {
                override fun onClick() {
                }
            })
    }
}