package com.android.academy.fundamentals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.academy.fundamentals.data.Actor

class ActorAdapter : RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {

    private val actors = MyApplication.getActors()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_actor, parent, false)
        return ActorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.onBind(actors[position])
    }

    override fun getItemCount(): Int {
        return actors.size
    }

    class ActorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.view_holder_actor_tv)
        private val image: ImageView = itemView.findViewById(R.id.view_holder_actor_iv)

        fun onBind(actor: Actor) {
            name.setText(actor.name)
            image.setImageResource(actor.image)
        }
    }

}



