package com.example.ui_example.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.ui_example.R
import com.example.ui_example.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val margin = view.context.resources.getDimension(R.dimen.card_margin)
        val offset = view.context.resources.getDimension(R.dimen.card_offset)

        binding.cardPager.adapter = CardSlideAdapter(listOf(1, 2, 3, 4))
        binding.cardPager.offscreenPageLimit = 2
        binding.cardPager.setPageTransformer { page, position ->
            val offset = position * (2 * offset + margin)
            page.translationX = -offset
        }
    }
}
