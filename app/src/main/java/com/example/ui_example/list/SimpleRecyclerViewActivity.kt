package com.example.ui_example.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui_example.databinding.ActivitySimpleRecyclerBinding
import com.example.ui_example.widget.SwipeHelper
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import kotlinx.android.synthetic.main.activity_simple_recycler.*

class SimpleRecyclerViewActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySimpleRecyclerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySimpleRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        val titleList = listOf("license", "Different Type RecyclerView cell", "title3", "title4", "title5", "title6", "title7", "title8")
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

        adapter.setListener(object : SimpleRecyclerAdapter.SimpleRecyclerViewListener {
            override fun onTapped(position: Int) {
                if (position == 0) {
                    presentOssLicensesMenuActivity()
                } else if (position == 1) {
                    presentDifferentTypeRecyclerViewActivity()
                }
            }
        })
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

    private fun presentOssLicensesMenuActivity() {
        val intent = Intent(this, OssLicensesMenuActivity::class.java)
        startActivity(intent)
    }

    private fun presentDifferentTypeRecyclerViewActivity() {
        val intent = Intent(this, DifferentTypeRecyclerViewActivity::class.java)
        startActivity(intent)
    }
}