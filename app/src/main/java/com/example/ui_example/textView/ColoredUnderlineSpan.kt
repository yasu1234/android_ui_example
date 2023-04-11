package com.example.ui_example.textView

import android.graphics.Canvas
import android.graphics.Paint
import android.text.style.LineBackgroundSpan

class ColoredUnderlineSpan(
    val underlineColor: Int,
    val startIndex: Int,
    val endIndex: Int
): LineBackgroundSpan {
    val paint = Paint()

    init {
        paint.color = underlineColor
        paint.strokeWidth = 3.0f
        paint.style = Paint.Style.FILL_AND_STROKE
    }

    // p0: canvas on which the span should be rendered This value cannot be null.
    // p1: paint used to draw text, which should be left unchanged on exit This value cannot be null.
    // p2: left position of the line relative to input canvas, in pixels This units of this value are pixels.
    // p3: right position of the line relative to input canvas, in pixels This units of this value are pixels.
    // p4: top position of the line relative to input canvas, in pixels This units of this value are pixels.
    // p5: baseline of the text relative to input canvas, in pixels This units of this value are pixels.
    // p6: bottom position of the line relative to input canvas, in pixels This units of this value are pixels.
    // p7: current text This value cannot be null.
    // p8: start character index of the line
    // p9: end character index of the line
    // p10: line number in the current text layout
    override fun drawBackground(
        p0: Canvas,
        p1: Paint,
        p2: Int,
        p3: Int,
        p4: Int,
        p5: Int,
        p6: Int,
        p7: CharSequence,
        p8: Int,
        p9: Int,
        p10: Int
    ) {
        if (startIndex >= endIndex) {
            throw Error("underlineEnd should be greater than underlineStart")
        }

        if (startIndex > p9 || endIndex < p8) {
            return
        }

        var offsetX = 0

        if (startIndex > p8) {
            offsetX = p1.measureText(p7.subSequence(p8, startIndex).toString()).toInt() ?: 0
        }

        val length: Int = p1.measureText(
            p7.subSequence(Math.max(p8, startIndex),
                Math.min(p9, endIndex)).toString()
        ).toInt() ?: 0

        p0.drawLine(
            offsetX.toFloat(),
            p5 + 3.0f,
            (length + offsetX).toFloat(),
            p5 + 3.0f, paint
        )
    }
}