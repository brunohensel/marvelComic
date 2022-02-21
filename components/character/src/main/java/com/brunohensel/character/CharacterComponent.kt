package com.brunohensel.character

import com.brunohensel.archcomponents.UIListComponent
import com.brunohensel.character.databinding.CharacterListItemBinding
import com.brunohensel.characters_api.Character

class CharacterComponent(
  private val container: CharacterListItemBinding,
  private val onItemClick: (Character) -> Unit
) : UIListComponent<CharacterComponentState>(container.root) {

  override fun render(state: CharacterComponentState) {
    with(container) {
      txtCharacterName.setOnClickListener { onItemClick.invoke(state.character) }
      txtCharacterId.text = state.character.characterId
      txtCharacterName.text = state.character.name
    }
  }
}