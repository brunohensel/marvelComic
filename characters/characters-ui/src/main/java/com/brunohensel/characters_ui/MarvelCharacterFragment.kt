package com.brunohensel.characters_ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.brunohensel.character.CharacterListComponent
import com.brunohensel.character.CharacterListComponentState
import com.brunohensel.logger.Log
import com.brunohensel.utils.viewmodel.ViewModelProvider
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MarvelCharacterFragment @Inject constructor(
  viewModelProvider: ViewModelProvider
) : Fragment(R.layout.fragment_marvel_character) {

  private val viewModel: MarvelCharacterViewModel by viewModelProvider.provideViewModel(fragment = this)

  override fun onCreate(savedInstanceState: Bundle?) {
    arguments = bundleOf("requestId" to "character123456")
    super.onCreate(savedInstanceState)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    lifecycleScope.launchWhenStarted {
      viewModel
        .state
        .onEach(::initComponent)
        .collect()
    }
  }

  private fun initComponent(state: CharacterListComponentState?) {
    state?.let {
      CharacterListComponent(
        container = requireActivity().findViewById(R.id.root),
        onItemClick = { Log.d("Item clicked: $it") }
      ).also { component -> component.newState(CharacterListComponentState(it.characters)) }
    }
  }
}