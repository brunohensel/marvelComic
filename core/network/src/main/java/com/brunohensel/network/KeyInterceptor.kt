package com.brunohensel.network

import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest

//Intercept the request to add some parameters for the authentication with the server
//more on [https://developer.marvel.com/documentation/authorization]
internal class KeyInterceptor : Interceptor {

  override fun intercept(chain: Chain): Response {
    val timestamp = System.currentTimeMillis().toString()
    var request = chain.request()
    val builder = request.url.newBuilder()

    builder.addQueryParameter("apikey", BuildConfig.CONSUMER_KEY)
      .addQueryParameter("hash", generateHash(timestamp + BuildConfig.SECRETE_KEY + BuildConfig.CONSUMER_KEY))
      .addQueryParameter("ts", timestamp)

    request = request.newBuilder().url(builder.build()).build()
    return chain.proceed(request)
  }

  private fun generateHash(input: String): String {
    val md5 = MessageDigest.getInstance("MD5")
    return BigInteger(1, md5.digest(input.toByteArray())).toString(16).padStart(32, '0')
  }
}