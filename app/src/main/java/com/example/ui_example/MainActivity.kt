package com.example.ui_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = TutorialAdapter(this)
        tutorialPager.adapter = pagerAdapter
    }

    private inner class TutorialAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return 3
        }

        override fun createFragment(position: Int): Fragment {
            if (position == 2) {
                return TutorialLastFragment()
            }

            return TutorialFragment()
        }

    }
}
