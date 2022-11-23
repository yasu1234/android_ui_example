package com.example.ui_example.layout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui_example.R
import kotlinx.android.synthetic.main.fragment_tab_layout.*

class TabLayoutFragment : Fragment() {
    private var positionParam = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    private fun setupUI() {
        tabFragmentTextView.text = positionParam.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            TabLayoutFragment().apply {
                arguments = Bundle().apply {
                    positionParam = position
                }
            }
    }
}