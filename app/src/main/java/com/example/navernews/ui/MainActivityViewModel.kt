package com.example.navernews.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navernews.data.repository.NewsRepository
import com.example.navernews.model.Items
import com.example.navernews.model.NewsList
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class MainActivityViewModel : ViewModel(){
    private val newsRepo = NewsRepository()
    private var newsList = mutableListOf<Items>()
    val newsListLiveData = MutableLiveData<List<Items>>() //

    private var oldQuery = ""

    fun getNewsList(query:String, indexInt:Int){
        newsRepo.getNaverNews(
            query,
            20,
            ((indexInt-1)*20)+1)
            .subscribe(object : SingleObserver<NewsList>{ // 관측하는얘
                override fun onSubscribe(d: Disposable) { //구독 첨시작했을떄(이번ㄴ에 사용은 안함)
                }

                override fun onSuccess(t: NewsList) { //성공을 관측했을 때

                    if(oldQuery != query) newsList.clear()
                    newsList.addAll(t.items)
                    oldQuery = query
                    newsListLiveData.value = newsList
                        var logIndex = ((indexInt-1)*20)+1

                        Log.d("TESTLOG", "index: $logIndex")
                }

                override fun onError(e: Throwable) { //실패를 관측했을 때
                    Log.e("TESTLOG", "error: $e")
                }
            })
    }

}