package com.alenal.template2020.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movie(val title: String, val description: String) : Parcelable