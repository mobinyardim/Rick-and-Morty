package ir.mobinyardim.rickandmorty.characters.di

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.mobinyardim.rickandmorty.characters.CharactersFragment
import ir.mobinyardim.rickandmorty.screens.CharactersFragmentProvider

@Module
@InstallIn(SingletonComponent::class)
interface CharactersModule {

    @Binds
    fun provideCharactersFragmentProvider(
        charactersFragmentProviderImpl: CharactersFragmentProviderImpl
    ): CharactersFragmentProvider
}