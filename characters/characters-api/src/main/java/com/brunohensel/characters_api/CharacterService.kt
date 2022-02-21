package com.brunohensel.characters_api

interface CharacterService {
  suspend fun fetchMarvelCharacter(): Result<List<Character>>
}