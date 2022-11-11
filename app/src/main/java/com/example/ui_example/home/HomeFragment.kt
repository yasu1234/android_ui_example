package com.example.ui_example.home

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_example.R
import com.example.ui_example.layout.TablayoutActivity
import com.example.ui_example.list.ExpandableListActivity
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

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "ActionBar"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_notifications_black_24dp)

        // Must define to be called onCreateOptionsMenu in the case of Fragment
        setHasOptionsMenu(true)

        val countList = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val adapter = HomeAdapter(countList)
        homeRecyclerView.adapter = adapter
        homeRecyclerView.layoutManager = GridLayoutManager(view.context, 2, RecyclerView.VERTICAL, false)

        adapter.setListner(object: HomeAdapter.HomeAdapterListner {
            override fun contentTapped(position: Int) {
                if (position == 0) {
                    presentSimpleRecyclerActivity()
                } else if (position == 1) {
                    presentTablayoutActivity()
                } else if (position == 2) {
                    presentExpandableListActivity()
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun presentSimpleRecyclerActivity() {
        val intent = Intent(requireContext(), SimpleRecyclerViewActivity::class.java)
        startActivity(intent)
    }

    private fun presentTablayoutActivity() {
        val intent = Intent(requireContext(), TablayoutActivity::class.java)
        startActivity(intent)
    }

    private fun presentExpandableListActivity() {
        val intent = Intent(requireContext(), ExpandableListActivity::class.java)
        startActivity(intent)
    }
}
