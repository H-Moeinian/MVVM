package com.example.FinalProject

import com.example.FinalProject.MovieDatabase.MovieClass
import com.example.FinalProject.MovieDatabase.Search
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class MVVMModel {

    fun fetchRelatedMovies(name:String):Observable<MovieClass>{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        val instance = retrofit.create(RetrofitInterface::class.java)
            .getRelatedMovies(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
        return instance
    }

    fun saveMovie(db:OpenDBHelper,movie:Search) {
        db.addData(movie)
    }

    fun fetchSavedMovies(db:OpenDBHelper): Observable<ArrayList<Search>> {

        return Observable.just(db.getData())

    }
}