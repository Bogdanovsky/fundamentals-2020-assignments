package com.android.academy.fundamentals

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.fundamentals.network.ImdbMovie
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MovieAdapter(
    private val onItemClickListener: OnItemClickListener,
    context: Context
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

//    private lateinit var movies: List<Movie>

    private val scope = CoroutineScope(Dispatchers.IO)
    private val context = context
    private var movies: List<ImdbMovie> = listOf()
    fun setMovies(value: List<ImdbMovie>) {
        movies = value
        notifyDataSetChanged()
    }


//    init {
//        scope.launch {
//            movies = movies ?: JsonMovieRepository(context).loadMovies()
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_movie, parent, false)
        return MovieViewHolder(view, onItemClickListener)

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movies[position], context)
    }

    override fun getItemCount(): Int {
        Log.i("TAG", "TAG #1_ movies.size = ${movies.size}")
        return movies.size
    }

    interface OnItemClickListener {
        fun onItemClicked(movieId: String)
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


        fun onBind(movie: ImdbMovie, context: Context) {
            title.text = movie.title
            Glide.with(context)
                .load(movie.image.toUri().buildUpon().scheme("https").build())
                .apply(
                    RequestOptions()
                    .placeholder(R.drawable.avengers_poster)
                    .error(R.drawable.black_widow_poster))
                .into(poster)
            Log.i("TAG", movie.image)
            parentalGuidance.setImageResource(
                if (false) R.drawable.parental_guidance_16 else R.drawable.parental_guidance_13
            )
            tag.text = movie.fullTitle
//            tag.text = if (movie.genres.isEmpty()) "" else {
//                var genresString = movie.genres[0].name
//                for (i in 2 until movie.genres.size) {
//                    genresString += ", ${movie.genres[i].name}"
//                }
//                genresString
//            }
            reviews.text = "${movie.imDBRating} by ${movie.imDBRatingCount} votes"
            duration.text = "${movie.year}"
            starIcon1.setImageResource(if (movie.imDBRating.toDouble() > 0) R.drawable.star_icon else R.drawable.star_icon_gray)
            starIcon2.setImageResource(if (movie.imDBRating.toDouble() > 2) R.drawable.star_icon else R.drawable.star_icon_gray)
            starIcon3.setImageResource(if (movie.imDBRating.toDouble() > 4) R.drawable.star_icon else R.drawable.star_icon_gray)
            starIcon4.setImageResource(if (movie.imDBRating.toDouble() > 6) R.drawable.star_icon else R.drawable.star_icon_gray)
            starIcon5.setImageResource(if (movie.imDBRating.toDouble() > 8) R.drawable.star_icon else R.drawable.star_icon_gray)

            itemView.setOnClickListener {
                onItemClickListener.onItemClicked(movie.id)
            }
        }
    }

}




