package com.ilmukomputeripb.patrolikarhutla.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilmukomputeripb.patrolikarhutla.databinding.ActivityKamusDetailBinding

class KamusDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKamusDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKamusDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}