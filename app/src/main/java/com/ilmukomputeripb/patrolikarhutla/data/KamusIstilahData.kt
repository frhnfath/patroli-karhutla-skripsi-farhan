package com.ilmukomputeripb.patrolikarhutla.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class KamusIstilahData(
    val title: String?,
    val description: String?,
    val source: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    companion object : Parceler<KamusIstilahData> {

        override fun KamusIstilahData.write(parcel: Parcel, flags: Int) {
            parcel.writeString(title)
            parcel.writeString(description)
            parcel.writeString(source)
        }

        override fun create(parcel: Parcel): KamusIstilahData {
            return KamusIstilahData(parcel)
        }
    }


}