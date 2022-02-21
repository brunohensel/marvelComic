package com.brunohensel.marvelcomic.application

import android.app.Application
import com.brunohensel.initializer.Initializer
import javax.inject.Inject

class AppInitializers @Inject constructor(private val initializer: Set<@JvmSuppressWildcards Initializer>) {

  fun init(app: Application) {
    initializer.forEach { it.init(app) }
  }
}