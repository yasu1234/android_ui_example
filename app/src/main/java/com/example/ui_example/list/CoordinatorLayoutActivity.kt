package com.example.ui_example.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.databinding.ActivityCoordinatorLayoutBinding

class CoordinatorLayoutActivity: AppCompatActivity() {
    private lateinit var binding: ActivityCoordinatorLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCoordinatorLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Note that if minHeight is not specified in the CollapsingToolbarLayout attribute,
        // the bottom element of the RecyclerView will not be fully displayed for the toolbar and will be cut off. (should be the same height as Toolbar)
        //
        // If you want the action bar itself to disappear,
        // change the attribute of CollapsingToolbarLayout to app:layout_scrollFlags="scroll" to hide the action bar as well.

        setupUI()
    }

    private fun setupUI() {
        setupActionBar()
    }

    private fun setupActionBar() {
        supportActionBar?.hide()
    }
}