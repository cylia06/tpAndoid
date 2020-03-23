package com.e.tp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.getResourceIdOrThrow
import kotlinx.android.synthetic.main.custom_component.view.*


class CustomeComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
): LinearLayout(context, attrs)


{
    init {
        LayoutInflater.from(context).inflate(R.layout.custom_component, this, true)
        orientation = VERTICAL

        attrs?.let {
            val typeArray = context.obtainStyledAttributes(it, R.styleable.custom_view_attributes)
            val textValue = typeArray.getString(R.styleable.custom_view_attributes_text)
            val  textColor = typeArray.getColor(R.styleable.custom_view_attributes_textColor, 0xFF808080.toInt())
            val image = typeArray.getResourceIdOrThrow(R.styleable.custom_view_attributes_src)
            typeArray.recycle()
              setText(textValue as String)
              setColor(textColor)
              setImage(image)
        }
    }
    fun setText(text: String) {
        val focussed = hasFocus()
        if (focussed) {
            my_edit.clearFocus()
        }
        my_edit.setText(text)
        if (focussed) {
            my_edit.requestFocus()
        }
    }
    fun setColor(color: Int){
        my_edit.setTextColor(color)
    }
    fun setImage(image: Int){
        this.my_image.setImageResource(image)
    }
}
