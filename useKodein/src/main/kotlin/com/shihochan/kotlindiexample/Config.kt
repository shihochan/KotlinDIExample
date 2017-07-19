package com.shihochan.kotlindiexample

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

class Config {

    companion object {
        val PROTOCOL = "https"
        val API_DOMAIN = "api.github.com"
        val API_ENDPOINT = PROTOCOL + "://" + API_DOMAIN
    }
}