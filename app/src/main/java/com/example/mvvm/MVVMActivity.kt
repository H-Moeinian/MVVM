package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.MovieDatabase.Search
import kotlinx.android.synthetic.main.activity_main.*

class MVVMActivity : AppCompatActivity() {
    lateinit var viewModel: MVVMViewModel
    val movieList = ArrayList<Search>()
    lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MVVMViewModel::class.java)

        btnSearch.setOnClickListener {
            val name = edtText.text.toString()
            viewModel.getMovies(name)
        }

        viewModel.getLiveData().observe(this, Observer {
            movieList.clear()
            movieList.addAll(it)
            adapter.notifyDataSetChanged()
        })


    }

     private fun setUpRecyclerView() {
        adapter = RecyclerViewAdapter(movieList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }


}
