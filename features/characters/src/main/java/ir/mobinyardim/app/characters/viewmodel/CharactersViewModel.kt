package ir.mobinyardim.app.characters.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mobinyardim.app.chractersrepository.CharactersRepository
import javax.inject.Inject
import ir.mobinyardim.app.models.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    private val savedCharacters = charactersRepository.getSavedCharacters()

    val characters = combine(
        savedCharacters,
        charactersRepository.getAllCharacters().cachedIn(viewModelScope)
    ) { savedCharacters, pagedCharacters ->
        pagedCharacters.map {
            it.copy(isSaved = savedCharacters.contains(it))
        }
    }

    fun saveCharacter(character: Character) = viewModelScope.launch(Dispatchers.IO) {
        charactersRepository.saveCharacter(character)
    }

    fun unSaveCharacter(character: Character) = viewModelScope.launch(Dispatchers.IO) {
        charactersRepository.unSaveCharacter(character)
    }
}