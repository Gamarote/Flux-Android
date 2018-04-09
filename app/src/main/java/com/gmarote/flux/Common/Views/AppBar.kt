package com.gmarote.flux.Common.Views

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.gmarote.flux.R
import kotlinx.android.synthetic.main.app_bar.view.*

/**
 * Created by Gabriel Marote on 4/4/2018.
 */
class AppBar: Toolbar {

    private lateinit var msg: String
    private var showBackButton: Boolean = false
    private var showAdditionalButton: Boolean = false
    private lateinit var additionalButtonIcon: Drawable

    constructor(
            context: Context,
            attributeSet: AttributeSet? = null
    ): super(context, attributeSet){
        initView(attributeSet)
    }

    constructor(
            context: Context,
            attributeSet: AttributeSet? = null,
            defStyleAttr: Int
    ): super(context, attributeSet, defStyleAttr){
        initView(attributeSet)
    }

    fun initView(attributeSet: AttributeSet? = null){
        try {
            if (attributeSet != null) {
                var attrs = context.obtainStyledAttributes(attributeSet, R.styleable.AppBar)
                this.msg = attrs.getString(R.styleable.AppBar_msg)
                this.showBackButton = attrs.getBoolean(R.styleable.AppBar_showBackButton, false)
                this.showAdditionalButton = attrs.getBoolean(R.styleable.AppBar_showAdditionalButton, false)
                this.additionalButtonIcon = attrs.getDrawable(R.styleable.AppBar_additionalButtonIcon)
                attrs.recycle()
            }
        } catch (e: Exception){ }

        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.app_bar, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        if(::msg.isInitialized) msgText.text = msg

        if(showBackButton) {
            backBtn.visibility = View.VISIBLE
            backBtn.setOnClickListener {
                (context as Activity).finish()
            }
        }

        if(showAdditionalButton && ::additionalButtonIcon.isInitialized) {
            additionalBtn.setImageDrawable(additionalButtonIcon)
            additionalBtn.visibility = View.VISIBLE
        }


    }
}