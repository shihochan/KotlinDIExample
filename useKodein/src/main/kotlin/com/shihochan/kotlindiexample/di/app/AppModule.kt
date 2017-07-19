package com.shihochan.kotlindiexample.di.app

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

fun providesApp(app: Application) = Kodein.Module {
  bind<Application>() with instance(app)
}
