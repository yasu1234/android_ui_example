package com.example.ui_example.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.databinding.ActivityExpandableListBinding

class ExpandableListActivity: AppCompatActivity() {
    private lateinit var binding: ActivityExpandableListBinding
    private lateinit var adapter: ExpandableListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExpandableListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        setupActionBar()
        setupListView()
    }

    private fun setupActionBar() {
        supportActionBar?.title = "ExpandableList"
    }

    private fun setupListView() {
        val dictionary = mapOf("title1" to listOf("foo", "bar", "fizz", "buzz"), "title2" to listOf("fizz"))
        adapter = ExpandableListAdapter(this, dictionary)
        binding.expandableList.setAdapter(adapter)
    }
}