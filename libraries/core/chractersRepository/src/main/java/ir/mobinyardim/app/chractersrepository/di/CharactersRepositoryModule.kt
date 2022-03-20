package ir.mobinyardim.app.chractersrepository.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.mobinyardim.app.chractersrepository.CharactersRepository
import ir.mobinyardim.app.chractersrepository.CharactersRepositoryImpl
import ir.mobinyardim.app.chractersrepository.network.Api
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CharactersRepositoryModule {

    @Provides
    @Singleton
    fun provideCharactersRepositoryModuleApi(
        retrofit: Retrofit
    ): Api = retrofit.create(Api::class.java)

    @Provides
    @Singleton
    fun provideCharacterRepository(
        charactersRepositoryImpl: CharactersRepositoryImpl
    ): CharactersRepository = charactersRepositoryImpl

}