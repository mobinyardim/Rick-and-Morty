package ir.mobinyardi.app.database.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.mobinyardi.app.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,
        callback: AppDatabase.CallBack
    ) = Room.databaseBuilder(
        app,
        AppDatabase::class.java, "app_database"
    ).addCallback(callback)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideUserDao(
        appDatabase: AppDatabase
    ) = appDatabase.characterDao()
}