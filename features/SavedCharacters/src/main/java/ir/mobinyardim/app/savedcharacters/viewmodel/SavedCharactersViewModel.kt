package ir.mobinyardim.app.savedcharacters.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mobinyardim.rickandmorty.chractersrepository.CharactersRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ir.mobinyardim.app.models.Character

@HiltViewModel
class SavedCharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    val savedCharacters = charactersRepository.getSavedCharactersAsPaging().cachedIn(viewModelScope)

    fun unSaveCharacter(character: Character) = viewModelScope.launch(Dispatchers.IO) {
        charactersRepository.unSaveCharacter(character)
    }
}