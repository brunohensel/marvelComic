package com.brunohensel.archcomponents

import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter

abstract class ListComponentAdapter<T : ComparableById>(
  config: AsyncDifferConfig<T> = DefaultDiffAsync.get()
) : ListAdapter<T, UIListComponent<T>>(config) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UIListComponent<T> {
    return this.getListComponent(viewType)
  }

  override fun onBindViewHolder(holder: UIListComponent<T>, position: Int) {
    val state: T = getItem(position)
    holder.newState(state)
  }

  override fun getItemViewType(position: Int): Int {
    return getItem(position).getType()
  }

  abstract fun getListComponent(viewType: Int): UIListComponent<T>

  fun update(list: List<T>) {
    submitList(list)
  }
}




