package com.brunohensel.characters_api

interface MarvelCharacterRepo {

  suspend fun getMarvelCharacter(): Result<List<Character>>
}