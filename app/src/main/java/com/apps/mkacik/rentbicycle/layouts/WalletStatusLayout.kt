package com.apps.mkacik.rentbicycle.layouts

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.apps.mkacik.rentbicycle.R
import kotlinx.android.synthetic.main.wallet_status_layout.view.*

class WalletStatusLayout(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val typedArray : TypedArray = context.obtainStyledAttributes(attrs, R.styleable.WalletStatusLayout,0,0)

    init {
        inflater.inflate(R.layout.wallet_status_layout,this)
        cashInteger.text = typedArray.getText(R.styleable.WalletStatusLayout_cashInteger)
        cashIntegerExtend.text = typedArray.getText(R.styleable.WalletStatusLayout_cashIntegerExtend)
        cashRest.text = typedArray.getText(R.styleable.WalletStatusLayout_cashRest)
        cashRestExtend.text = typedArray.getText(R.styleable.WalletStatusLayout_cashRestExtend)
    }
}