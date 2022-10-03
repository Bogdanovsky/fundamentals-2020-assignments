package com.android.academy.fundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.moveToMovieDetails)
        textView.setOnClickListener {
            moveToMovieDetails()
        }
    }

    private fun moveToMovieDetails() {
        val intent = Intent(this, MovieDetailsActivity::class.java)

//        val transmittedString = "string to transmit"
//        intent.putExtra(MovieDetailsActivity.TRANSMITTED_STRING, transmittedString)
//
//        val transmittedInt = 42
//        intent.putExtra(MovieDetailsActivity.TRANSMITTED_INT, transmittedInt)
//
//        val transmittedBoolean = false
//        intent.putExtra(MovieDetailsActivity.TRANSMITTED_BOOLEAN, transmittedBoolean)

        startActivity(intent)
    }
}
