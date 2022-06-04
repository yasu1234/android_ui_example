package com.example.ui_example.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_example.R
import com.example.ui_example.list.SimpleRecyclerViewActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countList = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val adapter = HomeAdapter(countList)
        homeRecyclerView.adapter = adapter
        homeRecyclerView.layoutManager = GridLayoutManager(view.context, 2, RecyclerView.VERTICAL, false)

        adapter.setListner(object: HomeAdapter.HomeAdapterListner {
            override fun contentTapped(position: Int) {
                presentSimpleRecyclerActivity()
            }
        })
    }

    private fun presentSimpleRecyclerActivity() {
        val intent = Intent(requireContext(), SimpleRecyclerViewActivity::class.java)
        startActivity(intent)
    }
}
