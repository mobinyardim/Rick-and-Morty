package ir.mobinyardim.rickandmorty.characters.di

import androidx.fragment.app.Fragment
import ir.mobinyardim.rickandmorty.characters.CharactersFragment
import ir.mobinyardim.rickandmorty.screens.CharactersFragmentProvider
import javax.inject.Inject

class CharactersFragmentProviderImpl @Inject constructor() : CharactersFragmentProvider {
    override fun newInstance(): Fragment {
        return CharactersFragment.newInstance()
    }
}