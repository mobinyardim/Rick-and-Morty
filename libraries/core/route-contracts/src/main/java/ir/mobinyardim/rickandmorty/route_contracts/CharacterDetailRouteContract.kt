package ir.mobinyardim.rickandmorty.route_contracts

import androidx.navigation.NavController

interface CharacterDetailRouteContract {

    companion object {
        val CHARACTER_ID_KEY = "characterId"
    }

    fun show(
        navController: NavController,
        characterId: Int
    )
}