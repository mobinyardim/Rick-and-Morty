package ir.mobinyardim.rickandmorty.characterdetail.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.mobinyardim.rickandmorty.route_contracts.CharacterDetailRouteContract
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CharacterDetailModule {

    @Binds
    fun provideCharacterDetailRouteContract(
        characterDetailRouteContractImpl: CharacterDetailRouteContractImpl
    ): CharacterDetailRouteContract

}