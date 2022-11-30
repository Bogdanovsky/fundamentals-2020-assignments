package com.android.academy.fundamentals

import android.app.Application
import android.util.Log
import com.android.academy.fundamentals.data.*
import kotlinx.coroutines.*
import java.io.FileNotFoundException
import java.io.IOException

class MyApplication : Application() {

    internal val repo = JsonMovieRepository(this)
    private val scope = CoroutineScope(Dispatchers.IO)
    lateinit var movies: List<Movie>
    val apiKey: String = "k_y6yu3k7z"


    init {
        Log.i("APP INIT", "--------> END")
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("APP INIT", "--------> onCreate 1")
        runBlocking { movies = repo.loadMovies() }
        Log.i("APP INIT", "--------> onCreate 2")
    }

    companion object {
        lateinit var instance: MyApplication
    }
}