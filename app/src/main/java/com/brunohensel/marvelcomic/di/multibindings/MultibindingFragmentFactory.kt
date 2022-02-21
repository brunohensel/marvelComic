package com.brunohensel.marvelcomic.di.multibindings

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.brunohensel.marvelcomic.di.components.FragmentComponent
import javax.inject.Inject

class MultibindingFragmentFactory @Inject constructor(private val factory: FragmentComponent.Factory) : FragmentFactory() {

  override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
    val component = factory.create()
    val fragmentClass = loadFragmentClass(classLoader, className)
    val map = component.fragmentMap
    return map[fragmentClass]?.get() ?: super.instantiate(classLoader, className)
  }
}