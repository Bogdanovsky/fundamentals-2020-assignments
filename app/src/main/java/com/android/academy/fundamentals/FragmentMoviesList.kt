package com.android.academy.fundamentals

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {

    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_movies_list, container, false)
//        layout.findViewById<ViewGroup>(R.id.constraint_layout).setOnClickListener{
//            requireActivity().apply {
//                supportFragmentManager.beginTransaction()
//                    .add(R.id.activity_main, FragmentMoviesDetails())
//                    .addToBackStack("details")
//                    .commit()
//            }
//        }
        Log.d("LOGG", "FragmentMovieList - onCreateView called")
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView = view.findViewById(R.id.fragment_movies_list_recyclerview)
        adapter = MovieAdapter()
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter
//        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        Log.d("LOGG", "FragmentMovieList - onViewCreated called")
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
}