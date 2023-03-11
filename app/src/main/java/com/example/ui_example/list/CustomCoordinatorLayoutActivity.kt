package com.example.ui_example.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui_example.databinding.ActivityCustomCoordinatorLayoutBinding

class CustomCoordinatorLayoutActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCustomCoordinatorLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCustomCoordinatorLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        setupActionBar()
        setupScrollView()
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.customCoordinatorLayoutToolBar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
    }

    private fun setupScrollView() {
        val titleList = listOf("license", "title2", "title3", "title4", "title5", "title6", "title7", "title8","title8","title8","title8")
        val adapter = SimpleRecyclerAdapter()
        binding.customCoordinatorLayoutRecyclerView.adapter = adapter
        binding.customCoordinatorLayoutRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter.differ.submitList(titleList)

        // depend on scroll, decide whether show ActionBar title or hidden
        // if recyclerView can not scroll(too short), this code can't work
        binding.customCoordinatorScrollView.setOnScrollChangeListener { view: View?, i: Int, i2: Int, i3: Int, i4: Int ->
            supportActionBar?.setDisplayShowTitleEnabled(i2 > 20)
            supportActionBar?.setDisplayShowHomeEnabled(i2 > 20)
            Log.e("scrollSize", (i2 > 20).toString())
        }
    }
}