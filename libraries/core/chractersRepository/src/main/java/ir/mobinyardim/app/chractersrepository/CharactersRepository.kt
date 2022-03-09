package ir.mobinyardim.app.chractersrepository

import androidx.paging.PagingData
import ir.mobinyardim.app.models.Character

interface CharactersRepository {

    fun getAllCharacters(): PagingData<Character>

    suspend fun getCharacter(id: Int): Character

    suspend fun saveCharacter(character: Character)

    suspend fun unSaveCharacter(character: Character)

    suspend fun getSavedCharacters(): List<Character>
}