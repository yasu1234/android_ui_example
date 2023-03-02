package com.example.ui_example.button

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.databinding.ActivityButtonsBinding

class ButtonsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityButtonsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityButtonsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}