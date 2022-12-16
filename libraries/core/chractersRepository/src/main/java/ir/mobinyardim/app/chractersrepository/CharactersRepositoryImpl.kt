package ir.mobinyardim.app.chractersrepository

import androidx.paging.*
import ir.mobinyardi.app.database.daos.CharacterDao
import ir.mobinyardim.app.chractersrepository.converter.toCharacter
import ir.mobinyardim.app.chractersrepository.converter.toCharacterEntity
import ir.mobinyardim.app.chractersrepository.converter.toDomain
import ir.mobinyardim.app.chractersrepository.network.Api
import ir.mobinyardim.app.chractersrepository.paging.CharactersPagingSource
import ir.mobinyardim.app.models.Character
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersRepositoryImpl @Inject constructor(
    private val remoteSource: Api,
    private val localSource: CharacterDao,
    private val charactersPagingSource: CharactersPagingSource
) : CharactersRepository {

    override fun getAllCharacters(viewModelScope: CoroutineScope): Flow<PagingData<Character>> {
        val allCharacters = Pager(
            config = PagingConfig(10, enablePlaceholders = false)
        ) {
            charactersPagingSource
        }.flow.cachedIn(viewModelScope)

        return combine(
            getSavedCharacters(),
            allCharacters
        ) { savedCharacters, pagedCharacters ->
            pagedCharacters.map {
                it.copy(isSaved = savedCharacters.contains(it))
            }
        }
    }

    override suspend fun getCharacter(id: Int): Character {
        return remoteSource.getCharacter(id).toCharacter()
    }

    override suspend fun saveCharacter(character: Character) {
        localSource.insert(character.toCharacterEntity())
    }

    override suspend fun unSaveCharacter(character: Character) {
        localSource.delete(character.toCharacterEntity())
    }

    override fun getSavedCharacters(): Flow<List<Character>> {
        return localSource.getAll().map { list ->
            list.map { it.toDomain() }
        }
    }

}