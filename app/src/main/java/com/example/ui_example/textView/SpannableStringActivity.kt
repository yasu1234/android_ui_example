package com.example.ui_example.textView

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.text.style.UnderlineSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ui_example.R
import com.example.ui_example.databinding.ActivitySpannableStringBinding
import kotlinx.android.synthetic.main.activity_spannable_string.*

class SpannableStringActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySpannableStringBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpannableStringBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

        binding.foregroundColorTextView.text = foregroundSpannable

        val imageSpannable = SpannableStringBuilder("Sample Text")
        val drawable: Drawable? = ContextCompat.getDrawable(this, R.drawable.ic_home_black_24dp)
        // to set lineHeight is responsible for various device
        drawable?.setBounds(0, 0, spannableImageTextView.lineHeight, spannableImageTextView.lineHeight)

        val span: ImageSpan? = drawable?.let { ImageSpan(it, ImageSpan.ALIGN_BASELINE) }
        imageSpannable.setSpan(span, imageSpannable.length - 1, imageSpannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.spannableImageTextView.text = imageSpannable

        val underLineSpannable = SpannableStringBuilder("Sample Text")
        underLineSpannable.setSpan(
            ColoredUnderlineSpan(Color.RED, 0, 3),
            0,
            3,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        binding.spannableUnderLineTextView.text = underLineSpannable
    }
}