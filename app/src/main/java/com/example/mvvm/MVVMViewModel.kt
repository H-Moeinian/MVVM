package com.example.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.MovieDatabase.Search
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


}