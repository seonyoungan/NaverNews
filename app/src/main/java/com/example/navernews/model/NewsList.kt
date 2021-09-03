package com.example.navernews.model

import com.google.gson.annotations.SerializedName

data class NewsList (
    //data class:데이터로 사용하기 위한 클래스
    @SerializedName("items") // 값(items)이랑 같이 내려오는 걸 파싱한다
    var items : List<Items> // List<>
        )

data class Items(
    @SerializedName("title")
    var title : String,
    @SerializedName("link")
    var link : String,
    @SerializedName("description")
    var description : String


)
