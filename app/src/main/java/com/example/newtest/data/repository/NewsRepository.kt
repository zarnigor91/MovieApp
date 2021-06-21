package com.example.newtest.data.repository

import com.example.newtest.data.model.NewsEntity
import com.example.newtest.data.model.NewsItem
import com.example.newtest.data.model1.MovieMode
import com.example.newtest.data.model1.ProductionCompany
import io.reactivex.Single

interface NewsRepository {
    fun getNews() : Single<List<ProductionCompany>>
}