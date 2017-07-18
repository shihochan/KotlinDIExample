package com.shihochan.kotlindiexample.di.app

import com.shihochan.kotlindiexample.MainApp
import com.shihochan.kotlindiexample.di.data.DataModule
import com.shihochan.kotlindiexample.di.scope.PerApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.DaggerApplication

/**
 * Created by Yuki Shiho on 2017/07/18.
 */

@Component(
    modules = arrayOf(
        AppModule::class,
        ActivityBinderModule::class,
        DataModule::class,
        AndroidSupportInjectionModule::class)
)
@PerApp interface AppComponent : AndroidInjector<MainApp> {

  @Component.Builder abstract class Builder : AndroidInjector.Builder<MainApp>() {
    abstract fun appModule(module: AppModule): Builder
    abstract fun dataModule(module: DataModule): Builder
  }

  object initializer {
    fun create(app: MainApp): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .dataModule(DataModule())
            .create(app)
  }
}
