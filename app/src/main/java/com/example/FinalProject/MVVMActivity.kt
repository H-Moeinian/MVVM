package com.example.FinalProject

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
    private val db=OpenDBHelper(this)


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
            adapter.notifyDataSetChanged()
        })

        btnShowDatabase.setOnClickListener {
            viewModel.getSavedMovies(db)
        }



    }



    private fun setUpRecyclerView() {
        adapter = RecyclerViewAdapter(movieList) {saveMovieInfoInDataBase(it)}
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }
    private fun setUpViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MVVMViewModel::class.java)    }
    private fun saveMovieInfoInDataBase(movie:Search){
        viewModel.saveMovieInfo(db,movie)
    }


}
