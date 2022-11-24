package com.example.ui_example.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.ui_example.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val margin = view.context.resources.getDimension(R.dimen.card_margin)
        val offset = view.context.resources.getDimension(R.dimen.card_offset)

        cardPager.adapter = CardSlideAdapter(listOf(1, 2, 3, 4))
        cardPager.offscreenPageLimit = 2
        cardPager.setPageTransformer { page, position ->
            val offset = position * (2 * offset + margin)
            page.translationX = -offset
        }
    }
}
