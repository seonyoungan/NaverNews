package com.example.navernews.data

import com.example.navernews.data.naverapi.BaseUrl
import com.example.navernews.data.naverapi.NaverApi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
//rest api를 쉽게 가져오기 위하ㄴ 라이브러리
object NetworkModule {
    fun getNaverApiRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BaseUrl.NAVER_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}