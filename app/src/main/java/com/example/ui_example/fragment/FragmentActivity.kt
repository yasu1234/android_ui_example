package com.example.ui_example.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.databinding.ActivityFragmentBinding

class FragmentActivity: AppCompatActivity(), Test1Fragment.Test1FragmentListener {
    private lateinit var binding: ActivityFragmentBinding

    private var isTest1Front = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUI()
    }

    private fun setupUI() {
        setupFragment()
    }

    private fun setupFragment() {
        val test1Fragment = Test1Fragment.newInstance("Here TEST1!")
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(binding.fragmentContainer.id, test1Fragment)
        transaction.commit()
    }

    override fun showTest2() {
        val test2Fragment = Test2Fragment.newInstance("Here TEST2!")
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(binding.fragmentContainer.id, test2Fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun isTest1Front() {
        isTest1Front = true
    }

    override fun onBackPressed() {
        super.onBackPressed()

        if (isTest1Front) finish() else supportFragmentManager.popBackStack()
    }
}