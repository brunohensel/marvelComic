package com.brunohensel.characters_ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brunohensel.character.CharacterListComponentState
import com.brunohensel.characters_api.MarvelCharacterRepo
import com.brunohensel.logger.Log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class MarvelCharacterViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
  private val characterRepo: MarvelCharacterRepo
) : ViewModel() {

  private val _state = MutableStateFlow<CharacterListComponentState?>(null)
  val state = _state.asStateFlow()

  init {
    fetchMarvelCharacter()
    Log.d("Id to fire some request: ${savedStateHandle.get<String>("requestId")}")
  }

  private fun fetchMarvelCharacter() {
    _state.update { it?.copy(listOf()) }
    viewModelScope.launch {
      characterRepo
        .getMarvelCharacter()
        .onSuccess { characters -> _state.update { CharacterListComponentState(characters) } }
        .onFailure(Log::e)
    }
  }
}