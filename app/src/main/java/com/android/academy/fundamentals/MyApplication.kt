package com.android.academy.fundamentals

import android.app.Application

private lateinit var singleton: Application


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        singleton = this
    }

    companion object {
        fun getMovies() : List<Movie> {
        return listOf(
            Movie(
                R.string.avengers_title,
                R.drawable.avengers_poster,
                R.string.avengers_parental_guidance,
                R.string.avengers_tag,
                4,
                R.string.avengers_review,
                R.string.avengers_duration
            ),
            Movie(
                R.string.tenet_title,
                R.drawable.tenet_poster,
                R.string.tenet_parental_guidance,
                R.string.tenet_tag,
                5,
                R.string.tenet_review,
                R.string.tenet_duration
            ),
            Movie(
                R.string.black_widow_title,
                R.drawable.black_widow_poster,
                R.string.black_widow_parental_guidance,
                R.string.black_widow_tag,
                4,
                R.string.black_widow_review,
                R.string.black_widow_duration
            ),
            Movie(
                R.string.wonder_woman_title,
                R.drawable.wonder_woman_poster,
                R.string.wonder_woman_tag,
                R.string.wonder_woman_parental_guidance,
                5,
                R.string.wonder_woman_review,
                R.string.wonder_woman_duration
            )
        )
        }
    }
}