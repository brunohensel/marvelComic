package com.brunohensel.services.character

import com.brunohensel.characters_api.Character
import com.brunohensel.characters_api.CharacterService
import javax.inject.Inject
import kotlin.Result

internal class CharacterServiceRequest @Inject constructor(private val api: CharacterApi) : CharacterService {

  override suspend fun fetchMarvelCharacter(): Result<List<Character>> = runCatching {
    val response = api.fetchMarvelCharacterAsync()
    response.toDomainModel()
  }
}
