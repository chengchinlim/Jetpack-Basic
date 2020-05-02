package com.cheng.jetpack_basic.navigation.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.cheng.jetpack_basic.R
import com.cheng.jetpack_basic.databinding.ActivityChallengeMainBinding

class ChallengeMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChallengeMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_challenge_main)

    }
}
