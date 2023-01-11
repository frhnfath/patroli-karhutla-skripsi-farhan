package com.ilmukomputeripb.patrolikarhutla.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilmukomputeripb.patrolikarhutla.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}