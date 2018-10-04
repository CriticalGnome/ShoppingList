package com.criticalgnome.shoppinglist.ui

import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager


class PoolLayout: ViewGroup {
    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet? = null): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0): super(context, attrs, defStyleAttr)

    private var deviceWidth: Int

    init {
        val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val deviceDisplay = Point()
        display.getSize(deviceDisplay)
        deviceWidth = deviceDisplay.x
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val count = childCount
        var currentWidth: Int
        var currentHeight: Int

        val childTop = paddingTop
        val childStart = paddingLeft
        val childEnd = measuredWidth - paddingEnd
        val childBottom = measuredHeight - paddingBottom
        val childHeight = childBottom - childTop
        val childWidth = childEnd - childStart

        var maxHeight = 0
        var currentTop = childTop
        var currentStart = childStart

        for (i in 0 until count) {
            val child = getChildAt(i)
            if (child.visibility == View.GONE) return

            //Get the maximum size of the child
            child.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST))
            currentHeight = child.measuredHeight
            currentWidth = child.measuredWidth

            //wrap is reach to the end
            if (currentStart + currentWidth >= childEnd) {
                currentStart = childStart
                currentTop += maxHeight
                maxHeight = 0
            }

            //do the layout
            child.layout(currentStart, currentTop, currentStart + currentWidth, currentTop + currentHeight)

            //store the max height
            if (maxHeight < currentHeight) {
                maxHeight = currentHeight
            }
            currentStart += currentWidth
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val count = childCount
        // Measurement will ultimately be computing these values.
        var maxHeight = 0
        var maxWidth = 0
        var childState = 0
        var mLeftWidth = 0
        var rowCount = 0

        // Iterate through all children, measuring them and computing our dimensions from their size.
        for (i in 0 until count) {
            val child = getChildAt(i)
            if (child.visibility == View.GONE) continue

            // Measure the child.
            measureChild(child, widthMeasureSpec, heightMeasureSpec)
            maxWidth += Math.max(maxWidth, child.measuredWidth)
            mLeftWidth += child.measuredWidth
            if ((mLeftWidth / deviceWidth) > rowCount) {
                maxHeight += child.measuredHeight
                rowCount++
            } else {
                maxHeight = Math.max(maxHeight, child.measuredHeight)
            }
            childState = combineMeasuredStates(childState, child.measuredState)

            // Check against our minimum height and width
            maxHeight = Math.max(maxHeight, suggestedMinimumHeight)
            maxWidth = Math.max(maxWidth, suggestedMinimumWidth)

            // Report our final dimensions.
            setMeasuredDimension(
                    View.resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                    View.resolveSizeAndState(maxHeight, heightMeasureSpec, childState shl View.MEASURED_HEIGHT_STATE_SHIFT)
            )
        }
    }

}