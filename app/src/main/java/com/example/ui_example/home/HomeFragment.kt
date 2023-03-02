package com.example.ui_example.home

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ui_example.R
import com.example.ui_example.button.ButtonsActivity
import com.example.ui_example.databinding.FragmentHomeBinding
import com.example.ui_example.dialog.CustomDialog
import com.example.ui_example.editText.EditTextActivity
import com.example.ui_example.layout.GridLayoutActivity
import com.example.ui_example.layout.TabLayoutActivity
import com.example.ui_example.list.ExpandableListActivity
import com.example.ui_example.list.SimpleRecyclerViewActivity
import com.example.ui_example.seekbar.SeekBarActivity
import com.example.ui_example.textView.SpannableStringActivity
import com.example.ui_example.widget.CustomGridItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupUI() {
        setupActionBar()
        setupRecyclerView()
    }

    private fun setupActionBar() {
        (activity as AppCompatActivity).supportActionBar?.title = "ActionBar"
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_notifications_black_24dp)

        // Must define to be called onCreateOptionsMenu in the case of Fragment
        setHasOptionsMenu(true)
    }

    private fun setupRecyclerView() {
        val countList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val adapter = HomeAdapter(countList)
        binding.homeRecyclerView.adapter = adapter

        val layoutManager = GridLayoutManager(requireContext(), 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (adapter.getItemViewType(position)) {
                        R.layout.grid_list -> 1
                        else -> 2
                    }
                }
            }
        }

        binding.homeRecyclerView.layoutManager = layoutManager
        binding.homeRecyclerView.addItemDecoration(CustomGridItemDecoration(requireContext()))

        adapter.setListener(object: HomeAdapter.HomeAdapterListener {
            override fun contentTapped(position: Int) {
                when (position) {
                    0 -> {
                        presentSimpleRecyclerActivity()
                    }
                    1 -> {
                        presentGridLayoutActivity()
                    }
                    2 -> {
                        presentExpandableListActivity()
                    }
                    3 -> {
                        presentTabLayoutActivity()
                    }
                    4 -> {
                        presentButtonsActivity()
                    }
                    5 -> {
                        presentEditTextActivity()
                    }
                    6 -> {
                        presentSpannableStringActivity()
                    }
                    7 -> {
                        presentSeekBarActivity()
                    }
                    8 -> {
                        showCustomDialog()
                    }
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

    private fun presentGridLayoutActivity() {
        val intent = Intent(requireContext(), GridLayoutActivity::class.java)
        startActivity(intent)
    }

    private fun presentTabLayoutActivity() {
        val intent = Intent(requireContext(), TabLayoutActivity::class.java)
        startActivity(intent)
    }

    private fun presentExpandableListActivity() {
        val intent = Intent(requireContext(), ExpandableListActivity::class.java)
        startActivity(intent)
    }

    private fun presentButtonsActivity() {
        val intent = Intent(requireContext(), ButtonsActivity::class.java)
        startActivity(intent)
    }

    private fun presentSpannableStringActivity() {
        val intent = Intent(requireContext(), SpannableStringActivity::class.java)
        startActivity(intent)
    }

    private fun presentEditTextActivity() {
        val intent = Intent(requireContext(), EditTextActivity::class.java)
        startActivity(intent)
    }

    private fun presentSeekBarActivity() {
        val intent = Intent(requireContext(), SeekBarActivity::class.java)
        startActivity(intent)
    }

    private fun showCustomDialog() {
        CustomDialog().apply {
            arguments = Bundle().apply {
                putString("title", this@HomeFragment.getString(R.string.title_notifications))
            }
        }.show(parentFragmentManager, "customDialog")
    }
}
