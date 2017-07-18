package com.shihochan.kotlindiexample.data

import com.shihochan.kotlindiexample.data.model.Follower
import io.reactivex.Flowable

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

interface GitHubRepository {
  fun getFollowers(userName: String): Flowable<List<Follower>>
}
