package com.brunohensel.marvelcomic.di.components

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.brunohensel.characters_impl.MarvelCharacterModule
import com.brunohensel.characters_ui.MarvelCharacterViewModelModule
import com.brunohensel.utils.anotations.scopes.ViewModelScope
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Provider

@ViewModelScope
@Subcomponent(
  modules = [
    MarvelCharacterViewModelModule::class,
    MarvelCharacterModule::class
  ]
)
interface ViewModelComponent {

  val viewModelMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

  @Subcomponent.Factory
  interface Factory {
    fun create(@BindsInstance savedStateHandle: SavedStateHandle): ViewModelComponent
  }
}