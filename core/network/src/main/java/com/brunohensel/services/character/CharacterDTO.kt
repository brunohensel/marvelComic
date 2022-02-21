package com.brunohensel.services.character

import com.google.gson.annotations.SerializedName

data class CharacterDTO(@SerializedName("data") val characterDataWrapper: CharacterDataWrapper)

data class CharacterDataWrapper(
  @SerializedName("offset") val offset: String,
  @SerializedName("results") val results: List<Result>,
  @SerializedName("total") val total: String
)

data class Result(
  @SerializedName("comics") val comics: ComicsDTO,
  @SerializedName("description") val description: String,
  @SerializedName("id") val id: String,
  @SerializedName("name") val name: String,
  @SerializedName("resourceURI") val resourceURI: String,
  @SerializedName("series") val series: SeriesDTO,
  @SerializedName("stories") val stories: StoriesDTO,
  @SerializedName("thumbnail") val thumbnail: CharacterImageDTO
)

data class ComicsDTO(
  @SerializedName("collectionURI") val collectionURI: String,
  @SerializedName("items") val items: List<ComicSummaryDTO>,
  @SerializedName("returned") val returned: String
)

data class ComicSummaryDTO(
  @SerializedName("name") val name: String,
  @SerializedName("resourceURI") val resourceURI: String
)

data class SeriesDTO(
  @SerializedName("collectionURI") val collectionURI: String,
  @SerializedName("items") val items: List<SeriesSummaryDTO>
)

data class SeriesSummaryDTO(
  @SerializedName("name") val name: String,
  @SerializedName("resourceURI") val resourceURI: String
)

data class StoriesDTO(
  @SerializedName("collectionURI") val collectionURI: String,
  @SerializedName("items") val items: List<StorySummaryDTO>,
  @SerializedName("returned") val returned: String
)

data class StorySummaryDTO(
  @SerializedName("name") val name: String,
  @SerializedName("resourceURI") val resourceURI: String,
  @SerializedName("type") val type: String
)

data class CharacterImageDTO(
  @SerializedName("extension") val extension: String,
  @SerializedName("path") val path: String
)
