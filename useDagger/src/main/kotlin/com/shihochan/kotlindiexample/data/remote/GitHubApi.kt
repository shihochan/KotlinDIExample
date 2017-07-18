package com.shihochan.kotlindiexample.data.remote

import com.shihochan.kotlindiexample.data.model.Follower
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

interface GitHubApi {

  @GET("/users/{userName}/followers")
  fun getFollowers(@Path("userName") userName: String): Flowable<List<Follower>>
}
