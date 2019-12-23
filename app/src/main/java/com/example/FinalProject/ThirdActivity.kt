package com.example.FinalProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.FinalProject.MovieDatabase.Article
import com.example.FinalProject.MovieDatabase.Search
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_third.*
import kotlinx.android.synthetic.main.secondrecycler_item.*

class ThirdActivity : AppCompatActivity() {

    private lateinit var viewModel: ThirdActivityViewModel
    lateinit var articleList : List<Article>
    private lateinit var adapter: ThirdRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val bundle: Bundle? = intent.extras
        val actor = bundle?.get("actors").toString()


        setUpRecyclerView()
        setUpViewModel()




        viewModel.getLiveData().observe(this, Observer {
            articleList = it
            adapter.notifyDataSetChanged()
        })





    }



    private fun setUpRecyclerView() {
        adapter = ThirdRecyclerViewAdapter(articleList)
        recyclerView2.adapter = adapter
        recyclerView2.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun getActorNews(actor: String) {
        viewModel.getNews(actor)
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(ThirdActivityViewModel::class.java)    }


}


