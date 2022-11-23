package com.example.ui_example.layout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.R
import kotlinx.android.synthetic.main.activity_grid_layout.*

class GridLayoutActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout)

        val listener = View.OnClickListener {
        }

        button1.setOnClickListener(listener)
    }
}