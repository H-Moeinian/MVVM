package com.example.FinalProject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.FinalProject.MovieDatabase.Search
import kotlinx.android.synthetic.main.activity_main.*

class MVVMActivity : AppCompatActivity() {
    private lateinit var viewModel: MVVMViewModel
    private val movieList = ArrayList<Search>()
    private lateinit var adapter: RecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        setUpViewModel()


        btnSearch.setOnClickListener {
            val name = edtText.text.toString()
            viewModel.getMovies(name)
        }

        viewModel.getLiveData().observe(this, Observer {
            movieList.clear()
            movieList.addAll(it)
        })

        viewModel.getLiveData1().observe(this, Observer {adapter.notifyDataSetChanged()
            val i = Intent(this, SecondActivity::class.java)
            i.putExtra("actors", it)
            startActivity(i)
        })





    }



    private fun setUpRecyclerView() {
        adapter = RecyclerViewAdapter(movieList){getMovieCast(it)}
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun getMovieCast(title: String) {
viewModel.getCast(title)
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MVVMViewModel::class.java)    }


}
