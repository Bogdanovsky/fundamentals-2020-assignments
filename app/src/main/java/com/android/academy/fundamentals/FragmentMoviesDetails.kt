package com.android.academy.fundamentals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.fundamentals.data.Movie
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FragmentMoviesDetails(private val movie: Movie) : Fragment() {

    private lateinit var adapter: ActorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(R.layout.fragment_movies_details, container, false)
        layout.findViewById<View>(R.id.back).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val actorsRecyclerView = view.findViewById<RecyclerView>(R.id.fragment_movies_details_recyclerview)
        adapter = ActorAdapter(movie)
        actorsRecyclerView.adapter = adapter
        // Title
        view.findViewById<TextView>(R.id.detailsTitle).text = movie.title
        // Image
        val image = view.findViewById<ImageView>(R.id.detailsImageView)
        Glide.with(image.context)
            .load(movie.detailImageUrl.toUri().buildUpon().scheme("https").build())
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.orig)
                    .error(R.drawable.orig))
            .into(image)
        // Parental Guidance
        view.findViewById<TextView>(R.id.detailsParentalGuidanceImageView)
            .text = "${movie.pgAge}+"
        // Genres
        view.findViewById<TextView>(R.id.tagTextView).text = if (movie.genres.isEmpty()) "" else {
            var genresString = movie.genres[0].name
            for (i in 2 until movie.genres.size) {
                genresString += ", ${movie.genres[i].name}"
            }
            genresString
        }
        //Reviews
        view.findViewById<TextView>(R.id.reviewsTextView).text = "${movie.reviewCount} REVIEWS"
        // Storyline
        view.findViewById<TextView>(R.id.storyline).text = movie.storyLine
        // Stars
        view.findViewById<ImageView>(R.id.starIconImageView).setImageResource(if (movie.rating > 0) R.drawable.star_icon else R.drawable.star_icon_gray)
        view.findViewById<ImageView>(R.id.starIcon2ImageView).setImageResource(if (movie.rating > 2) R.drawable.star_icon else R.drawable.star_icon_gray)
        view.findViewById<ImageView>(R.id.starIcon3ImageView).setImageResource(if (movie.rating > 4) R.drawable.star_icon else R.drawable.star_icon_gray)
        view.findViewById<ImageView>(R.id.starIcon4ImageView).setImageResource(if (movie.rating > 6) R.drawable.star_icon else R.drawable.star_icon_gray)
        view.findViewById<ImageView>(R.id.starIcon5ImageView).setImageResource(if (movie.rating > 8) R.drawable.star_icon else R.drawable.star_icon_gray)
    }
}