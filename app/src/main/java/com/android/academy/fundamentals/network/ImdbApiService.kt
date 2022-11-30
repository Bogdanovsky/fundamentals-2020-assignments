package com.android.academy.fundamentals.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://imdb-api.com/en/API/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val json = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
}

val contentType = "application/json".toMediaType()

val httpClient = OkHttpClient.Builder()
    .connectTimeout(10, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .build()

private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addConverterFactory(json.asConverterFactory(contentType))
    .client(httpClient)
    .baseUrl(BASE_URL)
    .build()

interface ImdbApiService {

    @GET("Top250Movies/k_y6yu3k7z")
    suspend fun getTop250Movies() : MovieResponse

//    @GET("FullCast/k_y6yu3k7z")
//    fun getFullCast(id: String)
}


object ImdbApi {
    val retrofitService: ImdbApiService by lazy { retrofit.create(ImdbApiService::class.java) }
}

// To parse the JSON, install kotlin's serialization plugin and do:
//
// val json    = Json(JsonConfiguration.Stable)
// val welcome = json.parse(Welcome.serializer(), jsonString)

@Serializable
data class MovieResponse (
    val items: List<ImdbMovie>,
    val errorMessage: String
)

