package com.android.academy.fundamentals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails : Fragment() {

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

        adapter = ActorAdapter()
        actorsRecyclerView.adapter = adapter
    }
}