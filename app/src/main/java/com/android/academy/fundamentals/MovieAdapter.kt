package com.android.academy.fundamentals

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {

    private var movies = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false)
        Log.d("LOGG", "MovieAdapter - onCreateVH called")
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        movies = MyApplication.getMovies()
        holder.onBind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun onBind(movie: Movie) {

        val title: TextView = itemView.findViewById(R.id.title)
        val poster: ImageView = itemView.findViewById(R.id.poster)
        val parentalGuidance: TextView = itemView.findViewById(R.id.parental_guidance)
        val tag: TextView = itemView.findViewById(R.id.tag)
        val reviews: TextView = itemView.findViewById(R.id.tag)
        val duration: TextView = itemView.findViewById(R.id.duration)
        val starIcon1: ImageView = itemView.findViewById(R.id.starIcon)
        val starIcon2: ImageView = itemView.findViewById(R.id.starIcon2)
        val starIcon3: ImageView = itemView.findViewById(R.id.starIcon3)
        val starIcon4: ImageView = itemView.findViewById(R.id.starIcon4)
        val starIcon5: ImageView = itemView.findViewById(R.id.starIcon5)

        title.setText(movie.title)
        poster.setImageResource(movie.poster)
        parentalGuidance.setText(movie.parentalGuidance)
        tag.setText(movie.tag)
        reviews.setText(movie.reviews)
        duration.setText(movie.duration)
        starIcon1.setImageResource(if (movie.rating > 0) R.drawable.star_icon else R.drawable.star_icon_gray)
        starIcon2.setImageResource(if (movie.rating > 1) R.drawable.star_icon else R.drawable.star_icon_gray)
        starIcon3.setImageResource(if (movie.rating > 2) R.drawable.star_icon else R.drawable.star_icon_gray)
        starIcon4.setImageResource(if (movie.rating > 3) R.drawable.star_icon else R.drawable.star_icon_gray)
        starIcon5.setImageResource(if (movie.rating > 4) R.drawable.star_icon else R.drawable.star_icon_gray)

    }
}

data class Movie(
    val title: Int,
    val poster: Int,
    val parentalGuidance: Int,
    val tag: Int,
    val rating: Int,
    val reviews: Int,
    val duration: Int
)
