package com.android.fundamentals.workshop01.step01.task

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import com.android.fundamentals.R

class WS01Step01AssignmentActivity : AppCompatActivity() {

    // This is a click counter
    private var counter = 0

    // These are views
    private var tvValue: AppCompatTextView? = null
    private var btnIncrementer: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        // Logging onCreate()
        Log.d(TAG, "$LOG_PREFIX::onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws01_step01)

        // Find view in layout by id and init view property
        tvValue = findViewById<AppCompatTextView>(R.id.tv_value).apply {
            // Set initial text
            text = getString(R.string.ws01_step01_activity_counter_text, counter)
        }

        // Find view in layout by id and init button property
        btnIncrementer = findViewById<AppCompatButton>(R.id.btn_incrementer).apply {
            // Set click listener
            setOnClickListener {
                // It will increment click counter
                counter++
                // And update text value on screen
                tvValue?.text = getString(R.string.ws01_step01_activity_counter_text, counter)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT_ARGUMENT, counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(KEY_COUNT_ARGUMENT)
        tvValue?.text = getString(R.string.ws01_step01_activity_counter_text, counter)
    }

    override fun onDestroy() {
        // Logging onDestroy()
        Log.d(TAG, "${LOG_PREFIX}::onDestroy")
        super.onDestroy()
    }

    companion object {
        private const val KEY_COUNT_ARGUMENT = "KEY_COUNT_ARGUMENT"
        private const val TAG = "WS01Step01Activity"
        private const val LOG_PREFIX = "WS01ST01"
    }
}

