package com.brunohensel.utils.viewmodel

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner

abstract class ViewModelProvider {

  @PublishedApi
  internal fun createViewModelFactory(
    owner: SavedStateRegistryOwner,
    args: Bundle? = null
  ): ViewModelProvider.Factory = onProvideViewModelFactory(owner, args)

  @Throws(IllegalStateException::class)
  protected abstract fun onProvideViewModelFactory(
    owner: SavedStateRegistryOwner,
    args: Bundle?
  ): ViewModelProvider.Factory

  inline fun <reified T : ViewModel> provideViewModel(fragment: Fragment): Lazy<T> {
    return fragment.viewModels {
      createViewModelFactory(fragment, fragment.arguments ?: bundleOf())
    }
  }
}