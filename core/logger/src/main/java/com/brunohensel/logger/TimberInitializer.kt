package com.brunohensel.logger

import android.app.Application
import com.brunohensel.initializer.Initializer
import timber.log.Timber
import javax.inject.Inject

internal class TimberInitializer @Inject constructor() : Initializer {
  override fun init(app: Application) {
    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    } else {
      Timber.uprootAll()
    }
  }
}