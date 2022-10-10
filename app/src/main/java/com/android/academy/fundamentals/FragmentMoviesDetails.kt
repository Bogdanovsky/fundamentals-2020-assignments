package com.android.academy.fundamentals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentMoviesDetails : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_movies_details, container, false)
        layout.findViewById<View>(R.id.back).setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }
        return layout
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentMoviesDetails().apply {}
    }
}