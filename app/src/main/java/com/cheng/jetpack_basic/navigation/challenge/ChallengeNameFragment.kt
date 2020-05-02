package com.cheng.jetpack_basic.navigation.challenge


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
import com.cheng.jetpack_basic.databinding.FragmentChallengeNameBinding

/**
 * A simple [Fragment] subclass.
 */
class ChallengeNameFragment : Fragment() {
    private lateinit var binding: FragmentChallengeNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_challenge_name, container, false)
        binding.nextBtn.setOnClickListener {
            val name = binding.nameEdt.text.toString()
            if (!TextUtils.isEmpty(name)) {
                val bundle = bundleOf("name" to name)
                it.findNavController().navigate(
                    R.id.action_challengeNameFragment_to_challengeEmailFragment, bundle)
            } else {
                Toast.makeText(activity, "Please insert your name", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}
