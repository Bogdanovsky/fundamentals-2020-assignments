package com.android.academy.fundamentals

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails : Fragment() {

    lateinit var adapter: ActorAdapter

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
//        Log.d("LOGG", "FragmentMoviesDetails - onCreateView called")
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val actorsRecyclerView = view.findViewById<RecyclerView>(R.id.fragment_movies_details_recyclerview)

        adapter = ActorAdapter()
        actorsRecyclerView.adapter = adapter
//        Log.d("LOGG", "FragmentMoviesDetails - onViewCreated called")
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentMoviesDetails().apply {}
    }
}