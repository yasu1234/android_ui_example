package com.example.ui_example.textView

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.R
import kotlinx.android.synthetic.main.activity_spannable_string.*

class SpannableStringActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_spannable_string)

        setupUI()
    }

    private fun setupUI() {
        val foregroundSpannable = SpannableStringBuilder("Sample Text")
        foregroundSpannable.setSpan(
            ForegroundColorSpan(Color.RED),
            0,
            2,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        foregroundColorTextView.text = foregroundSpannable
    }
}