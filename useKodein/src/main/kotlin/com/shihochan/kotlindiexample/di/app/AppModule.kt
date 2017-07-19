package com.shihochan.kotlindiexample.di.app

import android.app.Activity
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


inline fun inlineFun(fn: () -> Unit) {
  fn()
}

fun hoge() {
  inlineFun { print("hoge") }
}

val pair1 = 1 to 2
val pair2 = 1.to(2)

fun getName(clazz: Class<*>): String = clazz.simpleName

val name = getName(Activity::class.java)

val namesss = getName2<Activity>()

inline fun <reified T> getName2(): String = T::class.java.simpleName

