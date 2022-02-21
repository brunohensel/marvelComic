package com.brunohensel.characters_ui

import androidx.lifecycle.ViewModel
import com.brunohensel.utils.anotations.keys.ViewModelKey
import com.brunohensel.utils.anotations.scopes.ViewModelScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MarvelCharacterViewModelModule {

  @Binds
  @IntoMap
  @ViewModelScope
  @ViewModelKey(MarvelCharacterViewModel::class)
  fun bindMarvelCharacterViewModel(vm: MarvelCharacterViewModel): ViewModel
}