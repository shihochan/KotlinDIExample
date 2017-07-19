package com.shihochan.kotlindiexample.di.data

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.google.gson.GsonBuilder
import com.shihochan.kotlindiexample.Config
import com.shihochan.kotlindiexample.data.GitHubDataSource
import com.shihochan.kotlindiexample.data.GitHubRepository
import com.shihochan.kotlindiexample.data.remote.GitHubApi
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

fun dataModule() = Kodein.Module {
  bind<OkHttpClient.Builder>() with singleton {
    OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(Level.BODY))
  }

  bind<Retrofit>() with singleton {
    Retrofit.Builder()
        .baseUrl(Config.API_ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .callFactory(instance<OkHttpClient.Builder>().build())
        .build()
  }

  bind<GitHubApi>() with singleton { instance<Retrofit>().create(GitHubApi::class.java) }

  bind<GitHubRepository>() with singleton { GitHubDataSource(instance()) }
}
