package com.cheng.jetpack_basic.challenge


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cheng.jetpack_basic.R

/**
 * A simple [Fragment] subclass.
 */
class ChallengeTermsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_challenge_terms, container, false)
    }


}
