package com.example.ui_example.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.math.abs
import kotlin.math.max

abstract class SwipeHelper(private val recyclerView: RecyclerView
) : ItemTouchHelper.SimpleCallback(
    ItemTouchHelper.ACTION_STATE_IDLE,
    ItemTouchHelper.LEFT
) {
    private var swipedPosition = -1
    private val buttonsBuffer: MutableMap<Int, List<UnderlayButton>> = mutableMapOf()
    private val recoverQueue = object : LinkedList<Int>() {
        override fun add(element: Int): Boolean {
            if (contains(element)) return false
            return super.add(element)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private val touchListener = View.OnTouchListener { _, event ->
        if (swipedPosition < 0) return@OnTouchListener false
        buttonsBuffer[swipedPosition]?.forEach { it.handle(event) }
        recoverQueue.add(swipedPosition)
        swipedPosition = -1
        recoverSwipeItem()
        true
    }

    abstract fun instantiateUnderlayButton(position: Int): List<UnderlayButton>

    init {
        recyclerView.setOnTouchListener(touchListener)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val position = viewHolder.adapterPosition
        if (swipedPosition != position) recoverQueue.add(swipedPosition)
        swipedPosition = position
        recoverSwipeItem()
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val position = viewHolder.adapterPosition
        var maxDX = dX
        val itemView = viewHolder.itemView

        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            if (dX < -200) {
                if (!buttonsBuffer.containsKey(position)) {
                    buttonsBuffer[position] = instantiateUnderlayButton(position)
                }

                val buttons = buttonsBuffer[position] ?: return
                if (buttons.isEmpty()) return
                maxDX = max(-buttons.intrinsticWidth(), dX)
                drawButtons(c, buttons, itemView, maxDX)
            }
        } else {
            if (!buttonsBuffer.containsKey(position)) {
                buttonsBuffer[position] = instantiateUnderlayButton(position)
            }

            val buttons = buttonsBuffer[position] ?: return
            if (buttons.isEmpty()) return
            drawButtons(c, buttons, itemView, 0F)
        }
        super.onChildDraw(
            c,
            recyclerView,
            viewHolder,
            dX,
            dY,
            actionState,
            isCurrentlyActive
        )
    }

    private fun recoverSwipeItem() {
        while (!recoverQueue.isEmpty()) {
            val position = recoverQueue.poll() ?: return
            recyclerView.adapter?.notifyItemChanged(position)
        }
    }

    private fun drawButtons(
        canvas: Canvas,
        buttons: List<UnderlayButton>,
        itemView: View,
        dX: Float
    ) {
        var right = itemView.right
        buttons.forEach { button ->
            val width = button.intrinsticWidth / buttons.intrinsticWidth() * abs(dX)
            val left = right - width
            button.draw(canvas, RectF(left, itemView.top.toFloat(), right.toFloat(), itemView.bottom.toFloat()))

            right = left.toInt()
        }
    }

    class UnderlayButton(
        private val context: Context,
        private val title: String,
        textSize: Float,
        @ColorRes private val colorRes: Int,
        private val clickListener: UnderlayButtonClickListener) {
        private var clickableRegion: RectF? = null
        private val textSizeInPixcel = textSize * context.resources.displayMetrics.density
        private val horizontalPadding = 50.0f
        val intrinsticWidth: Float

        init {
            val titleBounds = Rect()
            intrinsticWidth = titleBounds.width() + 2 * horizontalPadding
        }

        fun draw(canvas: Canvas, rect: RectF) {
            val paint = Paint()

            paint.color = ContextCompat.getColor(context, colorRes)
            canvas.drawRect(rect, paint)

            paint.color = ContextCompat.getColor(context, android.R.color.white)
            paint.textSize = textSizeInPixcel
            paint.typeface = Typeface.DEFAULT_BOLD
            paint.textAlign = Paint.Align.LEFT

            val titleBounds = Rect()
            paint.getTextBounds(title, 0, title.length, titleBounds)

            val y = rect.height() / 2 + titleBounds.height() / 2 - titleBounds.bottom
            canvas.drawText(title, rect.left + horizontalPadding, rect.top + y, paint)

            clickableRegion = rect
        }

        fun handle(event: MotionEvent) {
            clickableRegion?.let {
                if (it.contains(event.x, event.y)) {
                    clickListener.onClick()
                }
            }
        }
    }

    interface UnderlayButtonClickListener {
        fun onClick()
    }
}

private fun List<SwipeHelper.UnderlayButton>.intrinsticWidth(): Float {
    if (isEmpty()) return 0.0f
    return map { it.intrinsticWidth }.reduce { acc, fl -> acc + fl }
}