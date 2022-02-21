package com.brunohensel.marvelcomic.application

import android.app.Activity
import android.app.Application
import com.brunohensel.marvelcomic.di.components.DaggerApplicationComponent

class MarvelComicApp : Application() {
  private val appComponentFactory by lazy { DaggerApplicationComponent.factory().create(this) }
  val appDelegate = appComponentFactory.appDelegate

  override fun onCreate() {
    super.onCreate()

    appComponentFactory
      .appInitializers
      .init(app = this)
  }
}

val Activity.injector get() = lazy { (application as MarvelComicApp).appDelegate }.value