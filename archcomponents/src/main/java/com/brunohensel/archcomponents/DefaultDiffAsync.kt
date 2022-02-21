package com.brunohensel.archcomponents

import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil

class DefaultDiffAsync<T> private constructor() : DiffUtil.ItemCallback<T>() {

  override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
    return (oldItem as ComparableById).idForComparison == (newItem as ComparableById).idForComparison
  }

  override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
    return (oldItem as ComparableById)::class == (newItem as ComparableById)::class
  }

  companion object {
    fun <T: ComparableById> get() = AsyncDifferConfig.Builder(DefaultDiffAsync<T>()).build()
  }
}