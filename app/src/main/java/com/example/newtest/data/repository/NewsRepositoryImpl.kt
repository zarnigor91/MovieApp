package com.example.newtest.data.repository

import com.example.newtest.data.datasourse.database.NewsDao
import com.example.newtest.data.datasourse.rest.INetService
import com.example.newtest.data.model1.MovieMode
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers

class NewsRepositoryImpl(
    private val netService: INetService,
    private val newsDao: NewsDao
) : NewsRepository {
    override fun getNews(): Single<List<MovieMode>> {
        return Single.create<List<MovieMode>>{emitter->

            netService.getMovie()
                    .subscribe(  {
                        emitter.onSuccess(it.results)
                    }, {
                        emitter.onError(it)
                    })
        }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
}


//    override fun getNews(): Single<List<MovieMode>> {
//        return netService.getMovie()
//            .map {
//                it.results
//            }
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//    }
}