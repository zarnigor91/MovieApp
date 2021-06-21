package com.example.newtest.data.datasourse.rest

import com.example.newtest.data.model.NewsListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface INetService {
    @GET("550?api_key=2906409ec09d8fa4ab53cf98caf0d4a4")
    fun getMovie(): Single<NewsListResponse>
}