package com.android.academy.fundamentals

import android.app.Application
import com.android.academy.fundamentals.data.Actor
import com.android.academy.fundamentals.data.Movie

class MyApplication : Application() {

    companion object {

        fun getActors() : List<Actor> {
            return listOf(
            Actor(R.drawable.robert_downey_junior, R.string.robert_downey_jr),
            Actor(R.drawable.chris_evans, R.string.chris_evans),
            Actor(R.drawable.mark_ruffalo, R.string.mark_ruffalo),
            Actor(R.drawable.chris_hemsworth, R.string.chris_hemsworth),
            Actor(R.drawable.robert_downey_junior, R.string.robert_downey_jr),
            Actor(R.drawable.chris_evans, R.string.chris_evans),
            Actor(R.drawable.mark_ruffalo, R.string.mark_ruffalo),
            Actor(R.drawable.chris_hemsworth, R.string.chris_hemsworth),
            Actor(R.drawable.robert_downey_junior, R.string.robert_downey_jr),
            Actor(R.drawable.chris_evans, R.string.chris_evans),
            Actor(R.drawable.mark_ruffalo, R.string.mark_ruffalo),
            Actor(R.drawable.chris_hemsworth, R.string.chris_hemsworth)
            )}

        fun getMovies() : List<Movie> {
        return listOf(
            Movie(
                R.string.avengers_title,
                R.drawable.avengers_poster,
                R.drawable.parental_guidance_13,
                R.string.avengers_tag,
                4,
                R.string.avengers_review,
                R.string.avengers_duration
            ),
            Movie(
                R.string.tenet_title,
                R.drawable.tenet_poster,
                R.drawable.parental_guidance_16,
                R.string.tenet_tag,
                5,
                R.string.tenet_review,
                R.string.tenet_duration
            ),
            Movie(
                R.string.black_widow_title,
                R.drawable.black_widow_poster,
                R.drawable.parental_guidance_13,
                R.string.black_widow_tag,
                4,
                R.string.black_widow_review,
                R.string.black_widow_duration
            ),
            Movie(
                R.string.wonder_woman_title,
                R.drawable.wonder_woman_poster,
                R.drawable.parental_guidance_13,
                R.string.wonder_woman_tag,
                5,
                R.string.wonder_woman_review,
                R.string.wonder_woman_duration
            )
        , Movie(
                R.string.avengers_title,
                R.drawable.avengers_poster,
                R.drawable.parental_guidance_13,
                R.string.avengers_tag,
                4,
                R.string.avengers_review,
                R.string.avengers_duration
            ),
            Movie(
                R.string.tenet_title,
                R.drawable.tenet_poster,
                R.drawable.parental_guidance_16,
                R.string.tenet_tag,
                5,
                R.string.tenet_review,
                R.string.tenet_duration
            ),
            Movie(
                R.string.black_widow_title,
                R.drawable.black_widow_poster,
                R.drawable.parental_guidance_13,
                R.string.black_widow_tag,
                4,
                R.string.black_widow_review,
                R.string.black_widow_duration
            ),
            Movie(
                R.string.wonder_woman_title,
                R.drawable.wonder_woman_poster,
                R.drawable.parental_guidance_13,
                R.string.wonder_woman_tag,
                5,
                R.string.wonder_woman_review,
                R.string.wonder_woman_duration
            ),
            Movie(
                R.string.avengers_title,
                R.drawable.avengers_poster,
                R.drawable.parental_guidance_13,
                R.string.avengers_tag,
                4,
                R.string.avengers_review,
                R.string.avengers_duration
            ),
            Movie(
                R.string.tenet_title,
                R.drawable.tenet_poster,
                R.drawable.parental_guidance_16,
                R.string.tenet_tag,
                5,
                R.string.tenet_review,
                R.string.tenet_duration
            ),
            Movie(
                R.string.black_widow_title,
                R.drawable.black_widow_poster,
                R.drawable.parental_guidance_13,
                R.string.black_widow_tag,
                4,
                R.string.black_widow_review,
                R.string.black_widow_duration
            ),
            Movie(
                R.string.wonder_woman_title,
                R.drawable.wonder_woman_poster,
                R.drawable.parental_guidance_13,
                R.string.wonder_woman_tag,
                5,
                R.string.wonder_woman_review,
                R.string.wonder_woman_duration
            )
        )
        }
    }
}