package com.brunohensel.services.character

import retrofit2.http.GET
import retrofit2.http.Query

internal interface CharacterApi {

  @GET("v1/public/characters")
  suspend fun fetchMarvelCharacterAsync(
    @Query("limit") limit: Int = 20,
    @Query("offset") offset: Int = 0
  ): CharacterDTO
}