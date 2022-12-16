package ir.mobinyardim.rickandmorty.characterdetail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import ir.mobinyardim.rickandmorty.chractersrepository.CharactersRepository
import ir.mobinyardim.rickandmorty.models.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CharacterDetailViewModel @AssistedInject constructor(
    @Assisted val characterId: Int,
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    val character = charactersRepository.getCharacter(characterId)

    fun saveCharacter(character: Character) = viewModelScope.launch(Dispatchers.IO) {
        charactersRepository.saveCharacter(character)
    }

    fun unSaveCharacter(character: Character) = viewModelScope.launch(Dispatchers.IO) {
        charactersRepository.unSaveCharacter(character)
    }
}