package com.github.cm.viewbindingdelegate.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.github.cm.viewbindingdelegate.R
import com.github.cm.viewbindingdelegate.databinding.ViewGroupMyBinding
import com.github.cm.viewbindingdelegate.viewBinding

/**
 * @description
 *
 * @author robert
 * @date 2023/8/14
 **/
class MyCustomViewGroup(context: Context, attrs: AttributeSet):LinearLayout(context, attrs) {
    private val binding by viewBinding(ViewGroupMyBinding::bind)

    init {
        inflate(context, R.layout.view_group_my, this)
        binding.name.text = "Hello, View Binding Delegate!\nCustomViewGroup"
    }
}