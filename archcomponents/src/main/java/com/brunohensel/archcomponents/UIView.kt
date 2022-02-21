package com.brunohensel.archcomponents

import android.view.ViewGroup
import androidx.annotation.IdRes

abstract class UIView<T>(val container: ViewGroup) {

  @get:IdRes
  abstract val containerId: Int
}