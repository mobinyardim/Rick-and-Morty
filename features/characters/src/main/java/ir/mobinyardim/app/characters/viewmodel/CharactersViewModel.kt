package ir.mobinyardim.app.characters.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.mobinyardim.app.chractersrepository.CharactersRepository
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    charactersRepository: CharactersRepository
) : ViewModel() {

    val characters = charactersRepository.getAllCharacters().cachedIn(viewModelScope)
}