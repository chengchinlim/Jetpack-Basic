package com.cheng.jetpack_basic.challenge


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
import com.cheng.jetpack_basic.databinding.FragmentChallengeEmailBinding

/**
 * A simple [Fragment] subclass.
 */
class ChallengeEmailFragment : Fragment() {

    private lateinit var binding: FragmentChallengeEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_challenge_email, container, false)
        binding.submitBtn.setOnClickListener {
            val email = binding.emailEdt.text.toString()
            if (!TextUtils.isEmpty(email)) {
                val name = requireArguments().getString("name")
                val bundle = bundleOf("email" to email,
                    "name" to name)
                it.findNavController().navigate(
                    R.id.action_challengeEmailFragment_to_challengeWelcomeFragment, bundle)
            } else {
                Toast.makeText(activity, "Please insert your email", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}
