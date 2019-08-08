package com.apps.mkacik.rentbicycle.layouts

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.apps.mkacik.rentbicycle.R
import kotlinx.android.synthetic.main.menu_button.view.*

class MenuButton(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val typedArray : TypedArray = context.obtainStyledAttributes(attrs,R.styleable.MenuButton,0,0)

    init {
        inflater.inflate(R.layout.menu_button,this)
        image.setImageDrawable(typedArray.getDrawable(R.styleable.MenuButton_image))
        description.text = typedArray.getText(R.styleable.MenuButton_description)
    }
}

