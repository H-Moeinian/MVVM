package com.example.FinalProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.secondrecycler_item.*


class SecondActivity : AppCompatActivity() {

   lateinit var actorList:List<String>
    private lateinit var adapter: SecondRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val actors = bundle?.get("actors").toString()
         actorList = actors.split(", ")




        setUpRecyclerView()

    }



    private fun setUpRecyclerView() {
        adapter = SecondRecyclerViewAdapter(actorList){getActorNews(it)}
        recyclerView1.adapter = adapter
        recyclerView1.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun getActorNews(it: String) {

        val i = Intent(this, ThirdActivity::class.java)
        i.putExtra("actors", it)
        startActivity(i)

    }


}

