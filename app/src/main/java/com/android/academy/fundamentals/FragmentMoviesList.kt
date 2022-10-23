package com.android.academy.fundamentals

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment(), RecyclerTouchListener.ClickListener {

    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_movies_list, container, false)
        val recyclerView = layout.findViewById<RecyclerView>(R.id.fragment_movies_list_recyclerview)

//        //////
        recyclerView.addOnItemTouchListener(
            RecyclerTouchListener(context, recyclerView, this)
        )

        Log.d("LOGG", "FragmentMovieList - onCreateView called")
        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler: RecyclerView = view.findViewById(R.id.fragment_movies_list_recyclerview)
        adapter = MovieAdapter()
//        recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        recycler.layoutManager = GridLayoutManager(this.context, 2)
        recycler.adapter = adapter

        Log.d("LOGG", "FragmentMovieList - onViewCreated called, ${requireContext() == this.context}")
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

    override fun onClick(view: View, position: Int) {
        Log.d("LOGG", "FragmentMoviesList onClick called")
        requireActivity().apply {
            supportFragmentManager.beginTransaction()
                .add(R.id.activity_main, FragmentMoviesDetails())
                .addToBackStack("details")
                .commit()
            Log.d("LOGG", "FragmentMoviesList onClick")
        }
    }
}

class RecyclerTouchListener(context: Context?, val recyclerView: RecyclerView, private val clickListener: ClickListener) : RecyclerView.OnItemTouchListener {

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        val item = rv.findChildViewUnder(e.x, e.y)
        item?.let {
            clickListener.onClick(it, 1)
        }
        return true
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
//        val item = rv.findChildViewUnder(e.x, e.y)
//        item?.let {
//            clickListener.onClick(it, 1)
//        }

    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        TODO("Not yet implemented")
    }

    interface ClickListener {
        fun onClick(view: View, position: Int)
//        fun onLongClick(view: View, position: Int)
    }

}