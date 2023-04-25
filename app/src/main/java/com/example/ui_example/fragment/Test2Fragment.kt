package com.example.ui_example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ui_example.R
import com.example.ui_example.databinding.FragmentTest1Binding
import com.example.ui_example.databinding.FragmentTest2Binding
import kotlinx.android.synthetic.main.fragment_test2.*

class Test2Fragment : Fragment() {
    private var title: String? = null

    private var _binding: FragmentTest2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTest2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.test2MessageTextView.text = title
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(titleParam: String) =
            Test2Fragment().apply {
                arguments = Bundle().apply {
                    title = titleParam
                }
            }
    }
}