package com.android.academy.fundamentals

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.fundamentals.network.ImdbMovie
import kotlinx.coroutines.runBlocking

class FragmentMoviesList : Fragment(), MovieAdapter.OnItemClickListener {

    private lateinit var adapter: MovieAdapter
    private val viewModel: FragmentMoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
//        viewModel.loadMovies()
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView = view.findViewById(R.id.fragment_movies_list_recyclerview)
        val spanCount = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 2 else 4
        recycler.layoutManager = GridLayoutManager(this.context, spanCount)
        adapter = MovieAdapter(this, requireContext())
        recycler.adapter = adapter
        viewModel.movies.observe(viewLifecycleOwner
        ) { adapter.setMovies(it) }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentMoviesList().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onItemClicked(movieId: String) {
//        viewModel.setSelectedMovie(movieId)
        requireActivity().apply {
            Log.i("TAG2", "movieId = ${movieId}")
            supportFragmentManager.beginTransaction()
                .add(R.id.activity_main, FragmentMoviesDetails.newInstance(movieId))
                .addToBackStack("details")
                .commit()
        }
    }
}