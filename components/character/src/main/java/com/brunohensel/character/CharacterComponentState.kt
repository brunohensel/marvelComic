package com.brunohensel.character

import com.brunohensel.archcomponents.ComparableById
import com.brunohensel.characters_api.Character

data class CharacterComponentState(val character: Character) : ComparableById {
  override val idForComparison: Any
    get() = character.characterId
}
