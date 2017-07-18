package com.shihochan.kotlindiexample.di.app

import com.shihochan.kotlindiexample.di.scope.PerActivity
import com.shihochan.kotlindiexample.ui.top.TopActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

@Module abstract class ActivityBinderModule {

  @PerActivity @ContributesAndroidInjector
  abstract fun contributeTopActivityInjector(): TopActivity
}