package ir.mobinyardim.app.characters.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mobinyardim.app.chractersrepository.CharactersRepository
import javax.inject.Inject
import ir.mobinyardim.app.models.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    val characters = charactersRepository.getAllCharacters().cachedIn(viewModelScope)

    fun saveCharacter(character: Character) = viewModelScope.launch(Dispatchers.IO) {
        charactersRepository.saveCharacter(character)
    }

    fun unSaveCharacter(character: Character) = viewModelScope.launch(Dispatchers.IO) {
        charactersRepository.unSaveCharacter(character)
    }
}