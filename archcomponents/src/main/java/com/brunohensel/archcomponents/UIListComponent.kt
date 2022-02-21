package com.brunohensel.archcomponents

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class UIListComponent<T>(itemView: ViewGroup) : ViewHolder(itemView) {

  var cache: T? = null
    private set

  protected abstract fun render(state: T)

  fun newState(state: T) {
    cache = state
    render(state)
  }
}