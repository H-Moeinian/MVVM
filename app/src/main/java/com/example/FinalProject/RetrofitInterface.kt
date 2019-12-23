package com.example.FinalProject


import com.example.FinalProject.MovieDatabase.ActorNewsClass
import com.example.FinalProject.MovieDatabase.DetailedMovieClass
import com.example.FinalProject.MovieDatabase.MovieClass
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("?apikey=4f3ca53")
    fun getRelatedMovies(@Query("s") s: String): Observable<MovieClass>

    @GET("?apikey=4f3ca53")
    fun getMovieInfo(@Query("t") t: String): Observable<DetailedMovieClass>

    @GET("?apikey=f0fb9da2a18d4ef8bda1bc42e3303310")
    fun getActorsNews(@Query("q") q: String): Observable<ActorNewsClass>



}