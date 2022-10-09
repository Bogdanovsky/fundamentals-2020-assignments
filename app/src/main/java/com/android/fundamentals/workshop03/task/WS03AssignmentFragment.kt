package com.android.fundamentals.workshop03.task

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.android.fundamentals.R

class WS03AssignmentFragment : Fragment() {

    private var btnIncrement: Button? = null
    private var btnChangeBackground: Button? = null
    private var listener: ClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_root_ws_03, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnIncrement = view.findViewById<Button>(R.id.btn_increment).apply {
            setOnClickListener { listener?.increaseCount() }
        }
        btnChangeBackground = view.findViewById<Button>(R.id.btn_change_background).apply {
            setOnClickListener { listener?.changeColor() }
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ClickListener) listener = context
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

//    fun setListener(l: ClickListener) {
//        listener = l
//    }

    interface ClickListener {
        fun increaseCount()
        fun changeColor()
    }
}