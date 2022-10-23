package com.android.academy.fundamentals

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorAdapter : RecyclerView.Adapter<ActorViewHolder>() {

    private val actors = MyApplication.getActors()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        Log.d("LOGG", "ActorAdapter - onCreateVH called START")
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_actor, parent, false)
        val actorViewHolder = ActorViewHolder(itemView)
        Log.d("LOGG", "ActorAdapter - onCreateVH called END")
        return actorViewHolder
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        Log.d("LOGG", "ActorAdapter - onBindVH called START")
        holder.onBind(actors[position])
        Log.d("LOGG", "ActorAdapter - onBindVH called END")
    }

    override fun getItemCount(): Int {
        Log.d("LOGG", "ActorAdapter - getItemCount called. Size = ${actors.size}")
        return actors.size
    }
}

class ActorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    init {
        Log.d("LOGG", "ActorVH - init called. ItemView - $itemView")
    }

    private val name: TextView = itemView.findViewById(R.id.view_holder_actor_tv)
    private val image: ImageView = itemView.findViewById(R.id.view_holder_actor_iv)

    fun onBind(actor: Actor) {
        Log.d("LOGG", "ActorAdapter - onBindVH called START")
        name.setText(actor.name)
        image.setImageResource(actor.image)
        Log.d("LOGG", "ActorAdapter - onBindVH called END")
    }
}

class Actor (
    val image: Int,
    val name: Int
)