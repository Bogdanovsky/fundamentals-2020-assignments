package com.android.academy.fundamentals

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.fundamentals.network.ImdbMovie
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.*

class FragmentMoviesDetails() : Fragment() {


    private val viewModel: FragmentMoviesViewModel by activityViewModels()
    private lateinit var adapter: ActorAdapter
    private lateinit var movie: ImdbMovie

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
        val movieId = requireArguments().getString(MOVIE_ID) // TAG
        viewModel.setSelectedMovie(movieId!!) // TAG
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//            viewModel.loadImdbTop250()
//            viewModel.selectedMovie.observe(viewLifecycleOwner) {
//                movie = it
//            }
        movie = viewModel.selectedMovie.value!!
        val actorsRecyclerView =
            view.findViewById<RecyclerView>(R.id.fragment_movies_details_recyclerview)
        adapter = ActorAdapter(movie)
        actorsRecyclerView.adapter = adapter
        // Title
        view.findViewById<TextView>(R.id.detailsTitle).text = movie.title
        // Image
        val image = view.findViewById<ImageView>(R.id.detailsImageView)
        Glide.with(image.context)
            .load(movie.image.toUri().buildUpon().scheme("https").build())
//            .load("https://i.imgur.com/DvpvklR.png")
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.orig)
                    .error(R.drawable.orig)
            )
//            .fitCenter()
//            .centerInside()
            .centerCrop()
            .into(image)
        // Parental Guidance
        view.findViewById<TextView>(R.id.detailsParentalGuidanceImageView)
            .text = "${16}+"
        // Genres
        view.findViewById<TextView>(R.id.tagTextView).text = movie.fullTitle
//        view.findViewById<TextView>(R.id.tagTextView).text = if (movie.genres.isEmpty()) "" else {
//            var genresString = movie.genres[0].name
//            for (i in 2 until movie.genres.size) {
//                genresString += ", ${movie.genres[i].name}"
//            }
//            genresString
//        }
        //Reviews
        view.findViewById<TextView>(R.id.reviewsTextView).text = "${movie.imDBRating} by ${movie.imDBRatingCount} votes"
        // Storyline
        view.findViewById<TextView>(R.id.storyline).text = movie.crew
        // Stars
        view.findViewById<ImageView>(R.id.starIconImageView)
            .setImageResource(if (movie.imDBRating.toDouble() > 0) R.drawable.star_icon else R.drawable.star_icon_gray)
        view.findViewById<ImageView>(R.id.starIcon2ImageView)
            .setImageResource(if (movie.imDBRating.toDouble() > 2) R.drawable.star_icon else R.drawable.star_icon_gray)
        view.findViewById<ImageView>(R.id.starIcon3ImageView)
            .setImageResource(if (movie.imDBRating.toDouble() > 4) R.drawable.star_icon else R.drawable.star_icon_gray)
        view.findViewById<ImageView>(R.id.starIcon4ImageView)
            .setImageResource(if (movie.imDBRating.toDouble() > 6) R.drawable.star_icon else R.drawable.star_icon_gray)
        view.findViewById<ImageView>(R.id.starIcon5ImageView)
            .setImageResource(if (movie.imDBRating.toDouble() > 8) R.drawable.star_icon else R.drawable.star_icon_gray)

//        view.findViewById<TextView>(R.id.cast).setOnClickListener {
////            runBlocking { Log.i("IMDB ----> ", ImdbApi.retrofitService.getTop250Movies().toString()) }
//            runBlocking { viewModel.loadImdbTop250() }
//        }
    }

    companion object {
        @JvmStatic
        fun newInstance(movieId: String) =
            FragmentMoviesDetails().apply {
                arguments = Bundle().apply {
                    putString(MOVIE_ID, movieId)
                    Log.i("TAG1", "movie.id = $movieId")
//                    putString(ARG_PARAM2, param2)
                }
            }

        private const val MOVIE_ID = "MOVIE_ID"
    }
}