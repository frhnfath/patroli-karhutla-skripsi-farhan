package com.ilmukomputeripb.patrolikarhutla.uifragment.Observasi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PatroliObservasiViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Patroli Observasi"
    }
    val text: LiveData<String> = _text
}