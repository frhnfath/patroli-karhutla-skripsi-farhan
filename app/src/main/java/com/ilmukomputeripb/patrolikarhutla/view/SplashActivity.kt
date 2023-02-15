package com.ilmukomputeripb.patrolikarhutla.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilmukomputeripb.patrolikarhutla.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}