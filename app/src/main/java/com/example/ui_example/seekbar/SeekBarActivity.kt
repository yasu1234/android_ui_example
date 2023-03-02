package com.example.ui_example.seekbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.databinding.ActivitySeekbarBinding

class SeekBarActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySeekbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeekbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}