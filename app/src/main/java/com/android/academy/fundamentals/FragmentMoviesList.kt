package com.android.academy.fundamentals

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.fundamentals.data.Movie

class FragmentMoviesList : Fragment(), MovieAdapter.OnItemClickListener {

    private lateinit var adapter: MovieAdapter
    private val viewModel: FragmentMoviesViewModel by viewModels { FragmentMoviesViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView = view.findViewById(R.id.fragment_movies_list_recyclerview)
        recycler.layoutManager = GridLayoutManager(this.context, 2)

        recycler.adapter = context?.let { MovieAdapter(this, it) }

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

    override fun onItemClicked(movie: Movie) {
        requireActivity().apply {
            supportFragmentManager.beginTransaction()
                .add(R.id.activity_main, FragmentMoviesDetails(movie))
                .addToBackStack("details")
                .commit()
        }
    }
}