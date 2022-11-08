package com.android.academy.fundamentals.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class JsonMovie(
    val id: Int,
    val title: String,
    val posterPicture: String,
    val backdropPicture: String,
    val runtime: Int,
    val genreIds: List<Int>,
    val actors: List<Int>,
    val ratings: Float,
    val votesCount: Int,
    val overview: String,
    val adult: Boolean
)