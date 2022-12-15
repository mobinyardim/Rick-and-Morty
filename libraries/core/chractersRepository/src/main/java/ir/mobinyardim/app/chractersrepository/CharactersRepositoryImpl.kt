package ir.mobinyardim.app.chractersrepository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import ir.mobinyardi.app.database.daos.CharacterDao
import ir.mobinyardim.app.chractersrepository.converter.toCharacter
import ir.mobinyardim.app.chractersrepository.converter.toCharacterEntity
import ir.mobinyardim.app.chractersrepository.converter.toDomain
import ir.mobinyardim.app.chractersrepository.network.Api
import ir.mobinyardim.app.chractersrepository.paging.CharactersPagingSource
import ir.mobinyardim.app.models.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharactersRepositoryImpl @Inject constructor(
    private val remoteSource: Api,
    private val localSource: CharacterDao,
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
        return remoteSource.getCharacter(id).toCharacter()
    }

    override suspend fun saveCharacter(character: Character) {
        localSource.insert(character.toCharacterEntity())
    }

    override suspend fun unSaveCharacter(character: Character) {
        localSource.delete(character.toCharacterEntity())
    }

    override suspend fun getSavedCharacters(): List<Character> {
        return localSource.getAll().map { it.toDomain() }
    }

}