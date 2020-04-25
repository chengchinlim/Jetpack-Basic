package com.cheng.jetpack_basic.demo

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.cheng.jetpack_basic.R
import com.cheng.jetpack_basic.databinding.FragmentDemoHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class DemoHomeFragment : Fragment() {
    private lateinit var binding: FragmentDemoHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_demo_home, container, false)
        binding.btn.setOnClickListener{
            if (!TextUtils.isEmpty(binding.edt.text.toString())) {
                val bundle = bundleOf("user_input" to binding.edt.text.toString())
                it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
            } else {
                Toast.makeText(activity, "Please insert your name", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

}
