package com.example.ui_example.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_example.R
import com.example.ui_example.home.HomeAdapter

class CustomGridItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val margin = context.resources.getDimensionPixelSize(R.dimen.custom_grid_item_margin)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val params = view.layoutParams as? GridLayoutManager.LayoutParams
        val manager = parent.layoutManager as? GridLayoutManager
        val spanIndex = params?.spanIndex ?: 0
        val spanSize = params?.spanSize ?: 1
        val spanCount = manager?.spanCount ?: 1
        val itemPosition = parent.getChildAdapterPosition(view)

        val isTop = itemPosition < 2
        val isStart = spanIndex == 0
        val isEnd = spanIndex + spanSize == spanCount

        when (parent.findContainingViewHolder(view)) {
            is HomeAdapter.CountListRecyclerViewHolder -> {
                // the first two column set margin
                outRect.set(0, if (isTop) margin else 0, 0, 0)
            }
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }
}