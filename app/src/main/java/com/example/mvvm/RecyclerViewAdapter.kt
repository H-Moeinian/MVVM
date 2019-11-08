package com.example.mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.MovieDatabase.Search
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*


class RecyclerViewAdapter(private val search: ArrayList<Search>) :
        RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
            return RecyclerViewHolder(
                view
            )
        }

        override fun getItemCount(): Int {

            return search.size

        }

        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            holder.onBind("${search[position].title} ,Production year: ${search[position].year}"
                ,search[position].poster)
        }


        class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun onBind(titleAndYear: String,poster:String) {
                itemView.txtTitle.text = titleAndYear
                Picasso.get().load(poster).into(itemView.imgPoster)


            }
        }
    }
