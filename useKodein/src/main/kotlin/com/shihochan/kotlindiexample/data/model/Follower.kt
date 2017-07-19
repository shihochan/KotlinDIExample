package com.shihochan.kotlindiexample.data.model

import com.google.gson.annotations.SerializedName
import paperparcel.PaperParcel
import paperparcel.PaperParcelable

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

@PaperParcel data class Follower(

    val login: String,
    val id: Int,
    @SerializedName("avatar_url") val avatarUrl: String,
    val url: String,
    @SerializedName("html_url") val htmlUrl: String,
    val type: String

) : PaperParcelable {
  companion object {
    @JvmField val CREATOR = PaperParcelFollower.CREATOR
  }
}
