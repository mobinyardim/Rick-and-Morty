package ir.mobinyardim.app.screens

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScreenProvidersStore @Inject constructor(
    val savedCharactersFragmentProvider: SavedCharactersFragmentProvider,
    val charactersFragmentProvider: CharactersFragmentProvider
)