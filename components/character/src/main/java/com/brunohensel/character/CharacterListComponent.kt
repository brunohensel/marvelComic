package com.brunohensel.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.brunohensel.archcomponents.ListComponentAdapter
import com.brunohensel.archcomponents.UIComponent
import com.brunohensel.archcomponents.UIListComponent
import com.brunohensel.character.databinding.CharacterListBinding
import com.brunohensel.character.databinding.CharacterListItemBinding
import com.brunohensel.characters_api.Character

class CharacterListComponent(
  private val container: ViewGroup,
  private val onItemClick: (Character) -> Unit
) : UIComponent<CharacterListComponentState>() {

  private val binding = CharacterListBinding.inflate(LayoutInflater.from(container.context), container, true)

  private val adapter = object : ListComponentAdapter<CharacterComponentState>() {
    override fun getListComponent(viewType: Int): UIListComponent<CharacterComponentState> {
      return CharacterComponent(
        container = CharacterListItemBinding.inflate(LayoutInflater.from(container.context), container, false),
        onItemClick = onItemClick::invoke
      )
    }
  }

  init {
    binding.characterList.layoutManager = LinearLayoutManager(container.context)
    binding.characterList.adapter = this.adapter
  }

  override fun render(state: CharacterListComponentState) {
    binding.characterList.isVisible = state.characters.isNotEmpty()
    state.characters
      .map(::CharacterComponentState)
      .let(adapter::update)
  }
}