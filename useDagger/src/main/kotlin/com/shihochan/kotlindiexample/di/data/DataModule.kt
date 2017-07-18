package com.shihochan.kotlindiexample.di.data

import com.google.gson.GsonBuilder
import com.shihochan.kotlindiexample.Config
import com.shihochan.kotlindiexample.data.GitHubDataSource
import com.shihochan.kotlindiexample.data.GitHubRepository
import com.shihochan.kotlindiexample.data.remote.GitHubApi
import com.shihochan.kotlindiexample.di.scope.PerApp
import dagger.Module
import dagger.Provides
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

@Module class DataModule {

  @Provides @PerApp fun providesOkHttpClient(): OkHttpClient.Builder
      = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(Level.BODY))

  @Provides @PerApp fun providesRetrofitBuilder(client: OkHttpClient.Builder): Retrofit
      = Retrofit.Builder()
          .baseUrl(Config.API_ENDPOINT)
          .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
          .callFactory(client.build())
          .build()

  @Provides @PerApp fun providesGitHubApi(retrofit: Retrofit): GitHubApi
      = retrofit.create(GitHubApi::class.java)

  @Provides @PerApp fun providesGitHubRepository(dataSource: GitHubDataSource): GitHubRepository
      = dataSource
}
