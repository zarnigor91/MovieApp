package com.example.newtest.app.feature.news.news


import com.example.newtest.data.model.NewsEntity
import com.example.newtest.data.model.NewsItem
import com.example.newtest.data.model1.MovieMode
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

interface NewsView : MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onNewsSuccess(news : List<MovieMode>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun onNewsError()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun action(newsItem: MovieMode)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun actionTitle(title: String, url: String, decrict: String)
}