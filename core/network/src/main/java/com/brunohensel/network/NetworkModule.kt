package com.brunohensel.network

import com.brunohensel.services.character.CharacterApiModule
import com.brunohensel.services.character.CharacterServiceModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(
  includes = [
    CharacterApiModule::class,
    CharacterServiceModule::class
  ]
)
object NetworkModule {

  @Provides
  @Singleton
  fun retrofit(): Retrofit =
    Retrofit.Builder()
      .client(OkhttpClientProvider.provide())
      .baseUrl("https://gateway.marvel.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
}