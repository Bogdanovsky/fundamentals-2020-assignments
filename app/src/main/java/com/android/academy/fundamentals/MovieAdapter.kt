package com.android.academy.fundamentals

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.fundamentals.data.JsonMovieRepository
import com.android.academy.fundamentals.data.Movie
import com.android.academy.fundamentals.data.MovieRepository
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MovieAdapter(private val onItemClickListener: OnItemClickListener, context: Context) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private lateinit var movies: List<Movie>
    private val scope = CoroutineScope(Dispatchers.IO)


    init {
        scope.launch {
            Log.i("TAG", "TAG #2_ ${JsonMovieRepository(context)}")
            movies = JsonMovieRepository(context).loadMovies()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false)
        return MovieViewHolder(view, onItemClickListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movies[position])
    }

    override fun getItemCount(): Int {
//        Log.i("TAG", "TAG #1_ movies.size = ${movies.size}")
        return movies.size
    }

    interface OnItemClickListener {
        fun onItemClicked(movie: Movie)
    }

    class MovieViewHolder(itemView: View, private val onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {

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
            title.text = movie.title
            Glide.with(poster.context)
                .load(movie.imageUrl.toUri().buildUpon().scheme("https").build())
                .into(poster)
            parentalGuidance.setImageResource(
                if (movie.pgAge >= 16) R.drawable.parental_guidance_16 else R.drawable.parental_guidance_13
            )
            tag.text = if (movie.genres.isEmpty()) "" else {
                movie.genres.toString()
            }
            reviews.text = "${movie.reviewCount} REVIEWS"
            duration.text = "${movie.runningTime} MIN"
            starIcon1.setImageResource(if (movie.rating > 0) R.drawable.star_icon else R.drawable.star_icon_gray)
            starIcon2.setImageResource(if (movie.rating > 2) R.drawable.star_icon else R.drawable.star_icon_gray)
            starIcon3.setImageResource(if (movie.rating > 4) R.drawable.star_icon else R.drawable.star_icon_gray)
            starIcon4.setImageResource(if (movie.rating > 6) R.drawable.star_icon else R.drawable.star_icon_gray)
            starIcon5.setImageResource(if (movie.rating > 8) R.drawable.star_icon else R.drawable.star_icon_gray)

            itemView.setOnClickListener {
                onItemClickListener.onItemClicked(movie)
            }
        }
    }

}




