package com.example.ui_example.seekbar

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.example.ui_example.R
import com.example.ui_example.databinding.ActivitySeekbarBinding
import kotlinx.android.synthetic.main.fragment_tutorial_last.*

class SeekBarActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySeekbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySeekbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        setupSeekBar()
    }

    private fun setupSeekBar() {
        // set initial progress.common range is from 0 to 100, but is able to customize.
        // If you customize progress range, set min and max value.
        binding.simpleSeekBar.progress = 50
        binding.simpleDiscreteSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            // when value changes listener
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if (p1 == 5) {
                    binding.simpleDiscreteSeekBar.thumb = AppCompatResources.getDrawable(
                        this@SeekBarActivity,
                        R.drawable.ic_home_black_24dp
                    )
                }
            }

            // when track touched
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            // when track stopped touching
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
    }
}