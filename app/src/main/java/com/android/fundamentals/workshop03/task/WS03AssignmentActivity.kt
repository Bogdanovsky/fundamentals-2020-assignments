package com.android.fundamentals.workshop03.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.fundamentals.R
import com.android.fundamentals.workshop03.WS03SecondFragment

class WS03AssignmentActivity : AppCompatActivity(), WS03AssignmentFragment.ClickListener {

    private val rootFragment =
        WS03AssignmentFragment()
//            .apply { setListener(this@WS03AssignmentActivity) }
    private val secondFragment = WS03SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ws02_ws03)

        supportFragmentManager.beginTransaction()
            .apply {
                add(R.id.persistent_container, rootFragment)
                add(R.id.fragments_container, secondFragment)
                commit()
            }
    }

    override fun increaseCount() {
        secondFragment.increaseValue()
    }

    override fun changeColor() {
        secondFragment.changeBackground()
    }
}