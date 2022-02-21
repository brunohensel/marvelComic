package com.brunohensel.services.character

import com.brunohensel.characters_api.CharacterService
import dagger.Binds
import dagger.Module

@Module
abstract class CharacterServiceModule {

  @Binds
  internal abstract fun bindCharacterService(impl: CharacterServiceRequest): CharacterService
}