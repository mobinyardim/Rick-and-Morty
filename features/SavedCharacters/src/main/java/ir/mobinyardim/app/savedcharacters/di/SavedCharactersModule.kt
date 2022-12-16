package ir.mobinyardim.app.savedcharacters.di

import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.mobinyardim.app.savedcharacters.SavedCharactersFragment
import ir.mobinyardim.rickandmorty.screens.SavedCharactersFragmentProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SavedCharactersModule {

    @Provides
    @Singleton
    fun provideSavedCharactersProvider(): SavedCharactersFragmentProvider {
        return object : SavedCharactersFragmentProvider {
            override fun newInstance(): Fragment {
                return SavedCharactersFragment.newInstance()
            }

        }
    }
}