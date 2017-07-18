package com.shihochan.kotlindiexample

import com.shihochan.kotlindiexample.di.app.AppComponent
import dagger.android.DaggerApplication
import timber.log.Timber

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

class MainApp : DaggerApplication() {

  override fun onCreate() {
    super.onCreate()
    Timber.plant(Timber.DebugTree())
  }

  override fun applicationInjector() = AppComponent.initializer.create(this)
}
