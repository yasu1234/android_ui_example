package com.example.ui_example.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.databinding.ActivityScrollViewBinding
import kotlinx.android.synthetic.main.activity_scroll_view.*

class ScrollViewActivity: AppCompatActivity() {
    private lateinit var binding: ActivityScrollViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // if you use scrollView, you can scroll contents inside scrollView like recyclerView
        // you want to use scrollView, contents inside scrollView wrap linerLayout/ConstraintLayout

        setupUI()
    }

    private fun setupUI() {
        setupButton()
    }

    private fun setupButton() {
        coordinatoLayoutShowButton.setOnClickListener {
            presentCoordinatorLayoutActivity()
        }
    }

    private fun presentCoordinatorLayoutActivity() {
        val intent = Intent(this, CoordinatorLayoutActivity::class.java)
        startActivity(intent)
    }
}