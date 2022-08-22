package com.example.tabelafipe.model.marca

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArrayMarcas(
    val nome: String,
    val codigo: String
): Parcelable