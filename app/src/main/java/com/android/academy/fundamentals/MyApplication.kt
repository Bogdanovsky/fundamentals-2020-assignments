package com.android.academy.fundamentals

import android.app.Application
import android.util.Log
import com.android.academy.fundamentals.data.*
import kotlinx.coroutines.*
import java.io.FileNotFoundException
import java.io.IOException

class MyApplication : Application() {
//    var movies = listOf<Movie>(
//        Movie(
//            1,
//            "Enf of Times",
//            "Blah-blah-blah-blah-blah-blah-blah-blah-blah",
//            "https://image.tmdb.org/t/p/w342/9HT9982bzgN5on1sLRmc1GMn6ZC.jpg",
//            "https://image.tmdb.org/t/p/w342/9HT9982bzgN5on1sLRmc1GMn6ZC.jpg",
//            8,
//            100500,
//            16,
//            135,
//            listOf(Genre(28, "Action")),
//            listOf(Actor(84433, "Lannick Gautry", "https://image.tmdb.org/t/p/w342/h94QUkKrwUncYhJ1eMz23kBAJuc.jpg")),
//            true
//    )
//    )

    lateinit var movies: List<Movie>

    init {
//        Log.i("TAG", "START")
//        try {
//            this.assets.open("genres.json")
//            Log.i("TAG", "START 2")
//        }
//       catch (e: Exception) {
//           Log.i("TAG", "START 3")
//           e.printStackTrace()
//       }
        val repo = JsonMovieRepository(this)
        Log.i("TAG", "Application init block 1")
        val scope = CoroutineScope(Dispatchers.IO)
        Log.i("TAG", "Application init block 2")
        scope.launch {
            Log.i("TAG", "Application init block 3")
            movies = repo.loadMovies()
        }
//        Log.i("TAG", "Application init block 4_ movies size = ${movies.size}")
    }
}