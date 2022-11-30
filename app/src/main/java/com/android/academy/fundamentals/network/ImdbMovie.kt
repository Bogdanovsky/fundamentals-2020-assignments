package com.android.academy.fundamentals.network

import com.squareup.moshi.JsonClass
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImdbMovie (
    val id: String,
    val rank: String,
    val title: String,
    val fullTitle: String,
    val year: String,
    val image: String,
    val crew: String,
    @SerialName("imDbRating")
    val imDBRating: String,
    @SerialName("imDbRatingCount")
    val imDBRatingCount: String
)