package com.example.FinalProject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.FinalProject.MovieDatabase.Search
import io.reactivex.disposables.CompositeDisposable

class MVVMViewModel : ViewModel() {
    val disposable = CompositeDisposable()
    val mvvmModel = MVVMModel()
    private val liveData = MutableLiveData<ArrayList<Search>>()

fun getMovies(name : String){
    disposable.add(mvvmModel.fetchRelatedMovies(name)
        .subscribe ({
            liveData.value = it.search

        },{ Log.d("tt",it.message)}))
}
    fun getLiveData():LiveData<ArrayList<Search>>{
        return liveData
    }

    fun saveMovieInfo(db:OpenDBHelper,movie:Search) {
        mvvmModel.saveMovie(db,movie)
    }

    fun getSavedMovies(db:OpenDBHelper) {
        disposable.add(mvvmModel.fetchSavedMovies(db)
            .subscribe ({
                liveData.value=it

            },{ Log.d("tt",it.message)}))    }


}