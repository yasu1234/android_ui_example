package com.example.ui_example.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.databinding.ActivityScrollViewBinding

class ScrollViewActivity: AppCompatActivity() {
    private lateinit var binding: ActivityScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // if you use scrollView, you can scroll contents inside scrollView like recyclerView
        // you want to use scrollView, contents inside scrollView wrap linerLayout/ConstraintLayout
    }
}