package com.example.navernews.data.naverapi

class BaseUrl {
    companion object {
        /*스태틱 : 정적변수 프로그램이 컴파일될때 여기에 선언된 건 미리 메모리에 올려두는 것
        (객체를 별도로 생성안하고 바로 사용 가능)

        자주쓰거나, 크지 않은 데이터는 스태틱 변수로 선언한다
        상수 선언 앞에 const 써주기
         */

        const val NAVER_API_BASE_URL = "https://openapi.naver.com/v1/"
        //메인액티비티에서 BaseUrl.NAVER_API_BASE_URL형태로 가져올 수 있음

        const val NAVER_API_GET_NEWS_JSON = "search/news.json"
        /*JSON형식 : api 요청했을 때 받아오는 데이터 형식. 크게 xml, json방식이 있음
        xml : <view> </view>
        json : 키랑 벨류의 쌍으로 이루어진 데이터 오브젝트(xml보다 빠르고 데이터가 작음)
         */

        const val NAVER_API_CLIENT_ID = "idT13ZzxXxW05kIJkCyZ"
        const val NAVER_API_SECRET = "0YvQzOkuvW"


        //요청하는 거 만들기 retrofit : rest api를 쉽게 쓰기 위해 만들어진 라이브러리

    }

}