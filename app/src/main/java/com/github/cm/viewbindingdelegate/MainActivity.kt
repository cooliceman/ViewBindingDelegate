package com.github.cm.viewbindingdelegate

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.github.cm.viewbindingdelegate.databinding.ActivityMainBinding
import com.github.cm.viewbindingdelegate.fragments.HomeFragment
import com.github.cm.viewbindingdelegate.fragments.SampleDialogFragment

class MainActivity : FragmentActivity() {
    private val binding by viewBinding(ActivityMainBinding::bind)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding.fragmentButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, HomeFragment.newInstance())
                .commitNow()
        }

        binding.dialogButton.setOnClickListener {
            SampleDialogFragment().show(supportFragmentManager, "SampleDialogFragment")
        }
    }

}
