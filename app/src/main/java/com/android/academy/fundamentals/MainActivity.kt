package com.android.academy.fundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.academy.fundamentals.data.JsonMovieRepository
import com.android.academy.fundamentals.data.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private var fragmentMoviesList: FragmentMoviesList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            fragmentMoviesList = FragmentMoviesList.newInstance()
            fragmentMoviesList.apply {
                supportFragmentManager.beginTransaction()
                    .add(R.id.activity_main, fragmentMoviesList!!, FRAGMENT_MOVIES_LIST_TAG)
                    .addToBackStack("list")
                    .commit()
            }
        } else {
            fragmentMoviesList = supportFragmentManager
                .findFragmentByTag(FRAGMENT_MOVIES_LIST_TAG) as FragmentMoviesList?
        }
    }

    companion object {
        const val FRAGMENT_MOVIES_LIST_TAG = "FragmentMoviesList"
    }
}
