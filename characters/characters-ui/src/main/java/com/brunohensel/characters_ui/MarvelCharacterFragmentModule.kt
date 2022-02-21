package com.brunohensel.characters_ui

import androidx.fragment.app.Fragment
import com.brunohensel.utils.anotations.keys.FragmentKey
import com.brunohensel.utils.anotations.scopes.FragmentScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MarvelCharacterFragmentModule {

  @Binds
  @IntoMap
  @FragmentScope
  @FragmentKey(MarvelCharacterFragment::class)
  fun bindMarvelCharacterFragment(fragment: MarvelCharacterFragment): Fragment
}