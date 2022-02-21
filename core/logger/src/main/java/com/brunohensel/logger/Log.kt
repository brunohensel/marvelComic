package com.brunohensel.logger

object Log {

  private val logger: Logger = TimberLogger

  @JvmStatic
  fun d(message: String, throwable: Throwable? = null) {
    logger.d(message, throwable)
  }

  @JvmStatic
  fun d(throwable: Throwable) {
    logger.d(throwable)
  }

  @JvmStatic
  fun e(message: String, throwable: Throwable? = null) {
    logger.e(message, throwable)
  }

  @JvmStatic
  fun e(throwable: Throwable) {
    logger.e(throwable)
  }

  @JvmStatic
  fun w(message: String, throwable: Throwable? = null) {
    logger.w(message, throwable)
  }

  @JvmStatic
  fun w(throwable: Throwable) {
    logger.w(throwable)
  }
}