package com.cheng.jetpack_basic.navigation.demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.cheng.jetpack_basic.R
import com.cheng.jetpack_basic.databinding.FragmentDemoSecondBinding

/**
 * A simple [Fragment] subclass.
 */
class DemoSecondFragment : Fragment() {
    private lateinit var binding: FragmentDemoSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_demo_second, container, false)
        val input = requireArguments().getString("user_input")
        binding.tv.text = input
        return binding.root
    }

}
