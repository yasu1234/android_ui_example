package com.example.ui_example.fragment

import android.Manifest
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ui_example.databinding.FragmentTest1Binding

class Test1Fragment : Fragment() {
    private var message: String? = null

    private var _binding: FragmentTest1Binding? = null
    private val binding get() = _binding!!

    private var listener: Test1FragmentListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTest1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        listener?.isTest1Front()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is Test1FragmentListener) {
            listener = context
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // check permission in Fragment
//        val permissionLauncher = registerForActivityResult(
//            ActivityResultContracts.RequestPermission()
//        ) { isGranted ->
//            if (isGranted) {
//                // Do if the permission is granted
//            }
//            else {
//                // Do otherwise
//            }
//        }
//
//        permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)

        binding.fragmentParamMessageTextView.text = message ?: ""

        binding.showTest2Button.setOnClickListener {
            listener?.showTest2()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param: String) =
            Test1Fragment().apply {
                arguments = Bundle().apply {
                    message = param
                }
            }
    }

    interface Test1FragmentListener {
        fun showTest2()
        fun isTest1Front()
    }
}