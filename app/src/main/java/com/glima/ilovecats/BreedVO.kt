package com.glima.ilovecats

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BreedVO(
    val id: String,
    val name: String,
    val description: String,
    val lifeSpan: String,
    val isRare: Boolean,
    val affectionLevel: Int,
    val intelligence: Int
) : Parcelable