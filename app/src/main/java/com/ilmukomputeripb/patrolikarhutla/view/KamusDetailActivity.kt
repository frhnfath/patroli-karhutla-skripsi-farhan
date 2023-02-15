package com.ilmukomputeripb.patrolikarhutla.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilmukomputeripb.patrolikarhutla.data.KamusIstilahData
import com.ilmukomputeripb.patrolikarhutla.databinding.ActivityKamusDetailBinding

class KamusDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKamusDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKamusDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kamusIstilahData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<KamusIstilahData>(EXTRA_DATA)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DATA)
        }

        if (kamusIstilahData != null) {
            supportActionBar?.title = kamusIstilahData.title
            binding.kamusTvDescription.text = kamusIstilahData.description
            binding.kamusTvSource.text = kamusIstilahData.source
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}