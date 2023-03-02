package com.example.ui_example.layout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.databinding.ActivityGridLayoutBinding
import kotlinx.android.synthetic.main.activity_grid_layout.*

class GridLayoutActivity: AppCompatActivity() {
    private lateinit var binding: ActivityGridLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGridLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listener = View.OnClickListener {
        }

        binding.button1.setOnClickListener(listener)
    }
}