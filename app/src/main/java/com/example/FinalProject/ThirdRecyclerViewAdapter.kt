package com.example.FinalProject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.FinalProject.MovieDatabase.Article
import com.example.FinalProject.MovieDatabase.Search
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*
import kotlinx.android.synthetic.main.thirdrecycler_item.view.*


class ThirdRecyclerViewAdapter(private val articles: List<Article>) :
    RecyclerView.Adapter<ThirdRecyclerViewAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.thirdrecycler_item, parent, false)
        return RecyclerViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {

        return articles.size

    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.onBind(
            articles[position].title, articles[position].author
            , articles[position].content, articles[position].urlToImage

        )
    }


    class RecyclerViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun onBind(title: String, author: String, content: String, image:String) {
            itemView.txtArticleTitle.text = title
            itemView.txtAuthor.text = author
            itemView.txtContent.text = content
            Picasso.get().load(image).into(itemView.imgNews)
        }


    }
}

