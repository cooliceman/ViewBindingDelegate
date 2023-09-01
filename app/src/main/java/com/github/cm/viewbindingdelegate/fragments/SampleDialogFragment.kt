package com.github.cm.viewbindingdelegate.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.github.cm.viewbindingdelegate.R
import com.github.cm.viewbindingdelegate.databinding.FragmentMyBinding
import com.github.cm.viewbindingdelegate.viewBinding

/**
 * @description
 *
 * @author robert
 * @date 2023/8/14
 **/
class SampleDialogFragment: DialogFragment() {
    private val binding by viewBinding(FragmentMyBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}