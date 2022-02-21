package com.brunohensel.characters_impl

import com.brunohensel.characters_api.MarvelCharacterRepo
import dagger.Binds
import dagger.Module

@Module
abstract class MarvelCharacterModule {

  @Binds
  internal abstract fun bindMarvelCharacterRepo(impl: MarvelCharacterRepository): MarvelCharacterRepo
}