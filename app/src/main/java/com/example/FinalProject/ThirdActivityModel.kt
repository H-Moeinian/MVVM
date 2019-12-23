package com.example.FinalProject

import com.example.FinalProject.MovieDatabase.ActorNewsClass
import com.example.FinalProject.MovieDatabase.MovieClass
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ThirdActivityModel {
    fun fetchActorNews(name:String): Observable<ActorNewsClass> {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/everything")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(RetrofitInterface::class.java)
            .getActorsNews(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}