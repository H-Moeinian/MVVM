package com.example.FinalProject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.FinalProject.MovieDatabase.Search
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*
import kotlinx.android.synthetic.main.secondrecycler_item.view.*


class SecondRecyclerViewAdapter(private val actors: List<String>, val function: (String) -> Unit) :
    RecyclerView.Adapter<SecondRecyclerViewAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.secondrecycler_item, parent, false)
        return RecyclerViewHolder(
            view, function
        )
    }

    override fun getItemCount(): Int {

        return actors.size

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.onBind(
            actors[position]
        )
    }


    class RecyclerViewHolder(itemView: View, val function: (String) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        fun onBind(actor: String) {
            itemView.txtActor.text = actor
            itemView.txtActor.setOnClickListener { function(actor) }


        }
    }
}
