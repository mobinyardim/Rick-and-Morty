package ir.mobinyardim.rickandmorty.database.daos

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.mobinyardim.rickandmorty.database.models.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterEntity: CharacterEntity)

    @Delete
    suspend fun delete(characterEntity: CharacterEntity)

    @Query("SELECT count(*) from characters where id=:id > 0")
    suspend fun isExist(id: Int): Boolean

    @Query("SELECT * FROM characters")
    fun getAll(): Flow<List<CharacterEntity>>

    @Query("SELECT * FROM characters")
    fun getAllAsPaging(): PagingSource<Int, CharacterEntity>
}