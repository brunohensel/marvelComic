package com.brunohensel.marvelcomic.di.components

import androidx.fragment.app.Fragment
import com.brunohensel.characters_ui.MarvelCharacterFragmentModule
import com.brunohensel.utils.anotations.scopes.FragmentScope
import dagger.Subcomponent
import javax.inject.Provider

@Subcomponent(modules = [MarvelCharacterFragmentModule::class])
@FragmentScope
interface FragmentComponent {

  val fragmentMap: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>

  @Subcomponent.Factory
  interface Factory {
    fun create(): FragmentComponent
  }
}