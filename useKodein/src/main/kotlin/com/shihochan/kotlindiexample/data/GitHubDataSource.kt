package com.shihochan.kotlindiexample.data

import com.shihochan.kotlindiexample.data.remote.GitHubApi

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

class GitHubDataSource constructor(
    private val gitHubApi: GitHubApi
) : GitHubRepository {

  override fun getFollowers(userName: String) = gitHubApi.getFollowers(userName)
}
