package ir.mobinyardim.rickandmorty.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.mobinyardim.rickandmorty.database.daos.CharacterDao
import ir.mobinyardim.rickandmorty.database.models.CharacterEntity
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [
        CharacterEntity::class,
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    class CallBack @Inject constructor(
        private val database: Provider<AppDatabase>
    ) : RoomDatabase.Callback()
}