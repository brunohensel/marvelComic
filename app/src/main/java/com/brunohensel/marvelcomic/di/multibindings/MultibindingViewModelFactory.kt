package com.brunohensel.marvelcomic.di.multibindings

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.savedstate.SavedStateRegistryOwner
import com.brunohensel.marvelcomic.di.components.ViewModelComponent
import com.brunohensel.utils.viewmodel.ViewModelProvider
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MultibindingViewModelFactory @Inject constructor(
  private val componentFactory: ViewModelComponent.Factory
) : ViewModelProvider() {

  override fun onProvideViewModelFactory(owner: SavedStateRegistryOwner, args: Bundle?): Factory {
    return object : AbstractSavedStateViewModelFactory(owner, args) {
      override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        val component = componentFactory.create(handle)
        val map = component.viewModelMap
        return map[modelClass]?.get() as T ?: throw IllegalStateException("Unknown ViewModel class: $modelClass")
      }
    }
  }
}