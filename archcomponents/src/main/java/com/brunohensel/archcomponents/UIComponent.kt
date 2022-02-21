package com.brunohensel.archcomponents

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.flow.Flow

interface UISimpleComponent<T> {
  val containerId: Int
  val userInteractionEvents: Flow<T>
}

abstract class UIComponent<T> {

  open fun newState(state: T) {
    renderOnUIThread(state)
  }

  private fun renderOnUIThread(state: T) {
    Handler(Looper.getMainLooper()).post {
      render(state)
    }
  }

  protected abstract fun render(state: T)

}