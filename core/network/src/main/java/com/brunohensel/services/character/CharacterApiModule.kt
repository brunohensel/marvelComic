package com.brunohensel.services.character

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object CharacterApiModule {

  @Provides
  @JvmStatic
  internal fun bindCharacterApi(retrofit: Retrofit): CharacterApi = retrofit.create(CharacterApi::class.java)
}