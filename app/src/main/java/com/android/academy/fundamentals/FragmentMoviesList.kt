package com.android.academy.fundamentals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentMoviesList : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_movies_list, container, false)
        layout.findViewById<ViewGroup>(R.id.avengers_constraint_layout).setOnClickListener{
            requireActivity().apply {
                supportFragmentManager.beginTransaction()
                    .add(R.id.activity_main, FragmentMoviesDetails())
                    .addToBackStack("details")
                    .commit()
            }
        }
        return layout
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