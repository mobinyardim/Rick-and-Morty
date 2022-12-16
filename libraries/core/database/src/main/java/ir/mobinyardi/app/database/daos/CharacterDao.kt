package ir.mobinyardi.app.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.mobinyardi.app.database.models.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(characterEntity: CharacterEntity)

    @Delete
    suspend fun delete(characterEntity: CharacterEntity)

    @Query("SELECT * FROM characters")
    fun getAll(): Flow<List<CharacterEntity>>
}