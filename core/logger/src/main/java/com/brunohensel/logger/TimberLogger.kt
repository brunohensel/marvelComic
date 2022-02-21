package com.brunohensel.logger

import android.os.Build
import timber.log.Timber
import java.util.regex.Pattern

internal object TimberLogger : Logger {

  private val instanceToIgnore = listOf(
    TimberLogger::class.java.name,
    Log::class.java.name
  )

  @get:JvmSynthetic
  @JvmStatic
  private val tag: String
    get() = Throwable().stackTrace
      .first { it.className !in instanceToIgnore }
      .let(::createStackElementTag)

  override fun d(message: String, throwable: Throwable?) {
    Timber.tag(tag).d(throwable, message)
  }

  override fun d(throwable: Throwable) {
    Timber.tag(tag).d(throwable)
  }

  override fun e(message: String, throwable: Throwable?) {
    Timber.tag(tag).e(throwable, message)
  }

  override fun e(throwable: Throwable) {
    Timber.tag(tag).e(throwable)
  }

  override fun w(message: String, throwable: Throwable?) {
    Timber.tag(tag).w(throwable, message)
  }

  override fun w(throwable: Throwable) {
    Timber.tag(tag).w(throwable)
  }

  private const val MAX_TAG_LENGTH = 23
  private val ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$")

  private fun createStackElementTag(element: StackTraceElement): String {
    var tag = element.className.substringAfterLast('.').substringBefore("$")
    val m = ANONYMOUS_CLASS.matcher(tag)
    if (m.find()) {
      tag = m.replaceAll("")
    }
    // Tag length limit was removed in API 26.
    return if (tag.length <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= 26) {
      tag
    } else {
      tag.substring(0, MAX_TAG_LENGTH)
    }
  }
}