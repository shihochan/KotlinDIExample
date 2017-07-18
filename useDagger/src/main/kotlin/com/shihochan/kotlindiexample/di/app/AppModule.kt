package com.shihochan.kotlindiexample.di.app

import android.app.Application
import com.shihochan.kotlindiexample.di.scope.PerApp
import dagger.Module
import dagger.Provides

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

@Module class AppModule(private val app: Application) {

  @Provides @PerApp fun providesApp() = app
}
