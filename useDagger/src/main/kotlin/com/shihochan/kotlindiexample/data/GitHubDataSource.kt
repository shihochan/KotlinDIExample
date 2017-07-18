package com.shihochan.kotlindiexample.data

import com.shihochan.kotlindiexample.data.remote.GitHubApi
import com.shihochan.kotlindiexample.di.scope.PerApp
import javax.inject.Inject

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

@PerApp
class GitHubDataSource @Inject constructor(
    private val gitHubApi: GitHubApi
) : GitHubRepository {

  override fun getFollowers(userName: String) = gitHubApi.getFollowers(userName)
}
