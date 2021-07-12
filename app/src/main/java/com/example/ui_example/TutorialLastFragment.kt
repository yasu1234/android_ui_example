package com.example.ui_example

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_tutorial_last.*

class TutorialLastFragment : Fragment() {
    interface  TutorialButtonClickListner {
        fun onClick()
    }

    lateinit var lister: TutorialButtonClickListner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        okButton.setOnClickListener {
            lister.onClick()
        }

        return inflater.inflate(R.layout.fragment_tutorial_last, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is TutorialButtonClickListner) {
            lister = context
        }

    }
}
