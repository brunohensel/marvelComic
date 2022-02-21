package com.brunohensel.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit.SECONDS

internal object OkhttpClientProvider {

  fun provide(): OkHttpClient {
    return OkHttpClient.Builder()
      .readTimeout(10, SECONDS)
      .connectTimeout(10, SECONDS)
      .addInterceptor(KeyInterceptor())
      .addInterceptor(HttpLogInterceptorProvider.provide())
      .build()
  }
}