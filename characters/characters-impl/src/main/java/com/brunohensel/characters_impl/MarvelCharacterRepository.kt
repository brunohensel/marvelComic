package com.brunohensel.characters_impl

import com.brunohensel.characters_api.Character
import com.brunohensel.characters_api.CharacterService
import com.brunohensel.characters_api.MarvelCharacterRepo
import javax.inject.Inject

internal class MarvelCharacterRepository @Inject constructor(private val service: CharacterService) : MarvelCharacterRepo {

  override suspend fun getMarvelCharacter(): Result<List<Character>> {
   return service.fetchMarvelCharacter()
  }
}