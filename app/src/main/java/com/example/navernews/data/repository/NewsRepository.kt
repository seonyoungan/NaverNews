package com.example.navernews.data.repository

import com.example.navernews.data.NetworkModule
import com.example.navernews.data.naverapi.NaverApi
import com.example.navernews.model.NewsList
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.create

class NewsRepository {
    private val naverApi = NetworkModule.getNaverApiRetrofit().create(NaverApi::class.java)

    fun getNaverNews(query:String, display:Int, start:Int):Single<NewsList> = naverApi
        .getNaverNewsJson(query, display, start)
        .subscribeOn(Schedulers.io()) // 네트워크를 처리하는 새로만든 쓰레드!
        .observeOn(AndroidSchedulers.mainThread()) //ui를 관리하는 메인 쓰레드!
    //네이버에이피아이 불렀잖아 그렇구나

//검색어, 언제부터시작할지, 3
}
//rx = 컴퓨터는 동시에 일을 한가지밖에 못해서, 동시에 일을 시키려면 쓰레드를 만들어야됨(쓰레드는 쉽게말하면 분신너낌
//볶음밥만들때 햇반 다데워지니까 타버림 -> 불하는 사람, 밥하는사람 둘이 일하면 되니까