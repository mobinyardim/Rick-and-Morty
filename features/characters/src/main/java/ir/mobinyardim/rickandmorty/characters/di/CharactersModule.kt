package ir.mobinyardim.rickandmorty.characters.di

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.mobinyardim.rickandmorty.characters.CharactersFragment
import ir.mobinyardim.rickandmorty.screens.CharactersFragmentProvider

@Module
@InstallIn(SingletonComponent::class)
class CharactersModule {

    @Provides
    fun provideCharactersFragmentProvider(): CharactersFragmentProvider {
        return object : CharactersFragmentProvider {
            override fun newInstance(): Fragment {
                return CharactersFragment.newInstance()
            }

        }
    }
}