package com.example.FinalProject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.FinalProject.MovieDatabase.Article
import io.reactivex.disposables.CompositeDisposable

class ThirdActivityViewModel : ViewModel(){
    val disposable = CompositeDisposable()
    val mvvmModel = ThirdActivityModel()
    private val liveData = MutableLiveData<List<Article>>()


    fun getNews(name : String){
        disposable.add(mvvmModel.fetchActorNews(name)
            .subscribe ({
                liveData.value = it.articles

            },{ Log.d("tt",it.message)}))
    }
    fun getLiveData(): LiveData<List<Article>> {
        return liveData
    }




}