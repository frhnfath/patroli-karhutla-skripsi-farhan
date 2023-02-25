package com.ilmukomputeripb.patrolikarhutla.uifragment.Darat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PatroliDaratViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Patroli Darat Fragment"
    }
    val text: LiveData<String> = _text
}