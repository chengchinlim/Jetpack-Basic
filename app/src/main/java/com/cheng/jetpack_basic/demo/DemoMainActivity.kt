package com.cheng.jetpack_basic.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.cheng.jetpack_basic.R
import com.cheng.jetpack_basic.databinding.ActivityDemoMainBinding

class DemoMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDemoMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_demo_main
        )

    }
}
