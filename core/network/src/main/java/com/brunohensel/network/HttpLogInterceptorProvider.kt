package com.brunohensel.network

import okhttp3.logging.HttpLoggingInterceptor

internal object HttpLogInterceptorProvider {

  fun provide(): HttpLoggingInterceptor {
    val logLevel = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    return HttpLoggingInterceptor().apply { level = logLevel }
  }
}