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
    private val liveData1 = MutableLiveData<String>()

fun getMovies(name : String){
    disposable.add(mvvmModel.fetchRelatedMovies(name)
        .subscribe ({
            liveData.value = it.search

        },{ Log.d("tt",it.message)}))
}
    fun getLiveData():LiveData<ArrayList<Search>>{
        return liveData
    }
    fun getLiveData1():LiveData<String>{
        return liveData1
    }

    fun getCast(title: String) {
        disposable.add(mvvmModel.fetchCast(title)
            .subscribe ({
                liveData1.value = it.actors

            },{ Log.d("tt",it.message)}))

    }


}