package com.android.academy.fundamentals

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private val movies = MyApplication.getMovies()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false)
//        Log.d("LOGG", "MovieAdapter - onCreateVH called. Parent - $parent")
        val movieVH = MovieViewHolder(view)
//        Log.d("LOGG", "MovieAdapter - VH created")
        return movieVH
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
//        Log.d("LOGG", "MovieAdapter - onBindVH called START")
        holder.onBind(movies[position])
//        Log.d("LOGG", "MovieAdapter - onBindVH called END")
    }

    override fun getItemCount(): Int {
//        Log.d("LOGG", "MovieAdapter - getItemCount called, size = ${movies.size}")
        return movies.size
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
//        Log.d("LOGG", "MovieVH - init called. ItemView - $itemView")
    }

    private val title: TextView = itemView.findViewById(R.id.movie_title_tv)
    private val poster: ImageView = itemView.findViewById(R.id.poster_iv)
    private val parentalGuidance: ImageView = itemView.findViewById(R.id.parental_guidance_iv)
    private val tag: TextView = itemView.findViewById(R.id.tag_tv)
    private val reviews: TextView = itemView.findViewById(R.id.reviews_tv)
    private val duration: TextView = itemView.findViewById(R.id.duration_tv)
    private val starIcon1: ImageView = itemView.findViewById(R.id.starIcon_iv)
    private val starIcon2: ImageView = itemView.findViewById(R.id.starIcon2_iv)
    private val starIcon3: ImageView = itemView.findViewById(R.id.starIcon3_iv)
    private val starIcon4: ImageView = itemView.findViewById(R.id.starIcon4_tv)
    private val starIcon5: ImageView = itemView.findViewById(R.id.starIcon5_iv)


    fun onBind(movie: Movie) {
//        Log.d("LOGG", "MovieVH - onBind called START. itemView $itemView")
        title.setText(movie.title)
        poster.setImageResource(movie.poster)
        parentalGuidance.setImageResource(movie.parentalGuidance)
        tag.setText(movie.tag)
        reviews.setText(movie.reviews)
        duration.setText(movie.duration)
        starIcon1.setImageResource(if (movie.rating > 0) R.drawable.star_icon else R.drawable.star_icon_gray)
        starIcon2.setImageResource(if (movie.rating > 1) R.drawable.star_icon else R.drawable.star_icon_gray)
        starIcon3.setImageResource(if (movie.rating > 2) R.drawable.star_icon else R.drawable.star_icon_gray)
        starIcon4.setImageResource(if (movie.rating > 3) R.drawable.star_icon else R.drawable.star_icon_gray)
        starIcon5.setImageResource(if (movie.rating > 4) R.drawable.star_icon else R.drawable.star_icon_gray)
//        Log.d("LOGG", "MovieAdapter - onBindVH called END")
    }
}

private val RecyclerView.ViewHolder.context
    get() = this.itemView.context

data class Movie(
    val title: Int,
    val poster: Int,
    val parentalGuidance: Int,
    val tag: Int,
    val rating: Int,
    val reviews: Int,
    val duration: Int
)
