package com.cheng.jetpack_basic.challenge


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.cheng.jetpack_basic.R
import com.cheng.jetpack_basic.databinding.FragmentChallengeWelcomeBinding

/**
 * A simple [Fragment] subclass.
 */
class ChallengeWelcomeFragment : Fragment() {
    private lateinit var binding: FragmentChallengeWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_challenge_welcome, container, false)
        binding.nameTv.text = requireArguments().getString("name")
        binding.emailTv.text = requireArguments().getString("email")
        binding.viewTermsBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_challengeWelcomeFragment_to_challengeTermsFragment)
        }
        return binding.root
    }
}
