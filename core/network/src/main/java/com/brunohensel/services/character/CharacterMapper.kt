package com.brunohensel.services.character

import com.brunohensel.characters_api.Character
import com.brunohensel.characters_api.CharacterImage
import com.brunohensel.characters_api.ComicSummary
import com.brunohensel.characters_api.Comics
import com.brunohensel.characters_api.Series
import com.brunohensel.characters_api.SeriesSummary
import com.brunohensel.characters_api.Stories
import com.brunohensel.characters_api.StorySummary

internal fun CharacterDTO.toDomainModel(): List<Character> = this.characterDataWrapper.results.map { result ->
  Character(
    characterId = result.id,
    comics = Comics(
      collectionURI = result.comics.collectionURI,
      items = result.comics.items.map(::asDomain),
      returned = result.comics.returned
    ),
    description = result.description,
    name = result.name,
    resourceURI = result.resourceURI,
    series = Series(collectionURI = result.series.collectionURI, items = result.series.items.map(::asDomain)),
    stories = Stories(collectionURI = result.stories.collectionURI, items = result.stories.items.map(::asDomain)),
    image = CharacterImage(extension = result.thumbnail.extension, path = result.thumbnail.path)
  )
}

private fun asDomain(dto: ComicSummaryDTO) = with(dto) { ComicSummary(name = name, resourceURI = resourceURI) }
private fun asDomain(dto: SeriesSummaryDTO) = with(dto) { SeriesSummary(name = name, resourceURI = resourceURI) }
private fun asDomain(dto: StorySummaryDTO) = with(dto) { StorySummary(name = name, resourceURI = resourceURI, type = type) }