package ir.mobinyardim.rickandmorty.screens

import androidx.fragment.app.Fragment


interface CharactersFragmentProvider {
    fun newInstance(): Fragment
}