package com.android.academy.fundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

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
