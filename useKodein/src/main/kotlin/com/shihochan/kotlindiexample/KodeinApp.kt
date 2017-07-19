package com.shihochan.kotlindiexample

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.KodeinAware
import com.github.salomonbrys.kodein.lazy
import com.shihochan.kotlindiexample.di.app.providesApp
import com.shihochan.kotlindiexample.di.data.dataModule
import timber.log.Timber

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

class KodeinApp : Application(), KodeinAware {

  override fun onCreate() {
    super.onCreate()
    Timber.plant(Timber.DebugTree())
  }

  override val kodein: Kodein by Kodein.lazy {
    import(providesApp(this@KodeinApp))
    import(dataModule())
  }
}
