package ir.mobinyardim.app.chractersrepository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.mobinyardim.app.chractersrepository.paging.CharactersPagingSource
import ir.mobinyardim.app.models.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersRepositoryImpl @Inject constructor(
    private val charactersPagingSource: CharactersPagingSource
) : CharactersRepository {

    override fun getAllCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(10, enablePlaceholders = false)
        ) {
            charactersPagingSource
        }.flow
    }

    override suspend fun getCharacter(id: Int): Character {
        TODO("Not yet implemented")
    }

    override suspend fun saveCharacter(character: Character) {
        TODO("Not yet implemented")
    }

    override suspend fun unSaveCharacter(character: Character) {
        TODO("Not yet implemented")
    }

    override suspend fun getSavedCharacters(): List<Character> {
        TODO("Not yet implemented")
    }

}