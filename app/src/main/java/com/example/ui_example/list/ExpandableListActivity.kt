package com.example.ui_example.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.R
import kotlinx.android.synthetic.main.activity_expandable_list.*

class ExpandableListActivity: AppCompatActivity() {
    private lateinit var adapter: ExpandableListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_expandable_list)

        setupUI()
    }

    private fun setupUI() {
        setupListView()
    }

    private fun setupListView() {
        val dictionary = mapOf("title1" to listOf("foo", "bar", "fizz", "buzz"), "title2" to listOf("fizz"))
        adapter = ExpandableListAdapter(this, dictionary)
        expandableList.setAdapter(adapter)
    }
}