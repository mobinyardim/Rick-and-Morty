package ir.mobinyardim.rickandmorty.screens

import androidx.fragment.app.Fragment


interface SavedCharactersFragmentProvider {
    fun newInstance(): Fragment
}