package com.ilmukomputeripb.patrolikarhutla.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ilmukomputeripb.patrolikarhutla.R
import com.ilmukomputeripb.patrolikarhutla.adapter.ListKamusAdapter
import com.ilmukomputeripb.patrolikarhutla.data.KamusIstilahData
import com.ilmukomputeripb.patrolikarhutla.databinding.ActivityKamusBinding

class KamusActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKamusBinding
    private lateinit var rvKamus: RecyclerView
    private val list = ArrayList<KamusIstilahData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKamusBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rvKamus = binding.rvKamus
        rvKamus.setHasFixedSize(true)

        list.addAll(getKamusData())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvKamus.layoutManager = LinearLayoutManager(this)
        val listKamusAdapter = ListKamusAdapter(list)
        rvKamus.adapter = listKamusAdapter
    }

    private fun getKamusData(): ArrayList<KamusIstilahData> {
        val kamusTitle = resources.getStringArray(R.array.title)
        val kamusDescription = resources.getStringArray(R.array.description)
        val kamusSource = resources.getStringArray(R.array.source)
        val listKamus = ArrayList<KamusIstilahData>()
        for (i in title.indices) {
            val kamusIstilahData = KamusIstilahData(kamusTitle[i], kamusDescription[i], kamusSource[i])

            Log.d("Kamus Data", "getKamusData: $kamusIstilahData")
            listKamus.add(kamusIstilahData)
        }
        return listKamus
    }
}