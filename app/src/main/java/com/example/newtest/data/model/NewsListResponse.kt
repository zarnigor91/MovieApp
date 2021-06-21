package com.example.newtest.data.model

import com.example.newtest.data.model1.MovieMode
import com.google.gson.annotations.SerializedName


data class NewsListResponse(
    @SerializedName("results")
    val results: List<MovieMode>
)