package com.example.FinalProject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.FinalProject.MovieDatabase.Search
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*


class RecyclerViewAdapter(private val search: ArrayList<Search>, val function: (String) -> Unit) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return RecyclerViewHolder(
            view, function
        )
    }

    override fun getItemCount(): Int {

        return search.size

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.onBind(
            search[position].title, search[position].year
            , search[position].poster
        )
    }


    class RecyclerViewHolder(itemView: View, val function: (String) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        fun onBind(title: String, year: String, poster: String) {
            itemView.txtTitle.text = "*$title*"
            itemView.txtYear.text = "year: $year"
            Picasso.get().load(poster).into(itemView.imgPoster)
            itemView.btnCast.setOnClickListener { function(title) }


        }
    }
}
