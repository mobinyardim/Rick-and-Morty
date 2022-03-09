package ir.mobinyardi.app.database.daos

import androidx.room.Delete
import androidx.room.Insert
import ir.mobinyardi.app.database.models.CharacterEntity

interface CharacterDao {

    @Insert
    suspend fun insert(characterEntity: CharacterEntity)

    @Delete
    suspend fun delete(characterEntity: CharacterEntity)

}