package com.brunohensel.characters_api

data class Character(
  val characterId: String,
  val comics: Comics,
  val description: String,
  val name: String,
  val resourceURI: String,
  val series: Series,
  val stories: Stories,
  val image: CharacterImage
)

data class Comics(
  val collectionURI: String,
  val items: List<ComicSummary>,
  val returned: String
)

data class ComicSummary(
  val name: String,
  val resourceURI: String
)

data class Series(
  val collectionURI: String,
  val items: List<SeriesSummary>
)

data class SeriesSummary(
  val name: String,
  val resourceURI: String
)

data class Stories(
  val collectionURI: String,
  val items: List<StorySummary>,
)

data class StorySummary(
  val name: String,
  val resourceURI: String,
  val type: String
)

data class CharacterImage(
  val extension: String,
  val path: String
)