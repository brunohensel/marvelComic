package com.brunohensel.marvelcomic.di.components

import android.app.Application
import com.brunohensel.logger.LoggerModule
import com.brunohensel.marvelcomic.application.AppDelegate
import com.brunohensel.marvelcomic.application.AppInitializers
import com.brunohensel.marvelcomic.di.modules.ActivityModule
import com.brunohensel.marvelcomic.di.modules.ViewModelFactoryModule
import com.brunohensel.marvelcomic.di.modules.ViewModelModule
import com.brunohensel.network.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    NetworkModule::class,
    LoggerModule::class,
    ActivityModule::class,
    ViewModelModule::class,
    ViewModelFactoryModule::class
  ]
)
interface ApplicationComponent {

  val appInitializers: AppInitializers
  val appDelegate: AppDelegate

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance app: Application): ApplicationComponent
  }
}