package com.brunohensel.logger

internal interface Logger {

  fun d(message: String, throwable: Throwable? = null)

  fun d(throwable: Throwable)

  fun e(message: String, throwable: Throwable? = null)

  fun e(throwable: Throwable)

  fun w(message: String, throwable: Throwable? = null)

  fun w(throwable: Throwable)
}