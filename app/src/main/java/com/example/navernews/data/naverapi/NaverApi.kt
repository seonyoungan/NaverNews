package com.example.navernews.data.naverapi

import com.example.navernews.model.NewsList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NaverApi {
    //네이버에서 가져올 url을 만들어준다.
    //@Headers 문법임

    @Headers("X-Naver-Client-Id: " + BaseUrl.NAVER_API_CLIENT_ID,
        "X-Naver-Client-Secret: " + BaseUrl.NAVER_API_SECRET)
    @GET(BaseUrl.NAVER_API_GET_NEWS_JSON)
    fun getNaverNewsJson(
        @Query("query") query: String,
        //뒷부분 query를 자동으로 붙여줌
        @Query("display") display : Int,
        @Query("start") start : Int

    ) : Single<NewsList> //return값
    //single : rx java... rt kt... thread(프로세스의 젤 작은 단위)
    /*
    rx 4대요소
    1. Observable : 관측이 가능한 강물이다. 관측하는 애를 만들면 데이터를 가져올수있겠지. 그게 옵져버야
    2. Observer : 관측하는 애를 만들면 데이터를 가져올수있겠지. 그게 옵져버야
    3. Subscription : 옵저버가 옵저베이블을 구독한 것이다
    4. Scheduler : 옵저버가 관측하게 하는 것을 스케쥴러라는 별도의 쓰레드를 만들어서 실행함
     */
}