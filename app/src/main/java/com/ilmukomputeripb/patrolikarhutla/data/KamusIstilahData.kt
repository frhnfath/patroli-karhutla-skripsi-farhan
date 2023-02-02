package com.ilmukomputeripb.patrolikarhutla.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class KamusIstilahData (
    val title: String,
    val description: String,
    val source: String
) : Parcelable