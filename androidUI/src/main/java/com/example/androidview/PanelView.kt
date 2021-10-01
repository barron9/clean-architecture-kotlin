package com.example.androidview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout

/**
 * PanelView
 *
 *
 *
 * @author a
 */
class PanelView : LinearLayout {

    constructor(c: Context?) : super(c) {
        init(c!!)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context!!)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context!!)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

    }

    fun init(c: Context) {
        val li: LayoutInflater =
            c.applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                    as LayoutInflater
        li.inflate(R.layout.panelview, this)
    }
}