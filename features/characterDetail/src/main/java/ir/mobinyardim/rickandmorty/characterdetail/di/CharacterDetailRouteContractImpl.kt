package ir.mobinyardim.rickandmorty.characterdetail.di

import android.os.Bundle
import androidx.navigation.NavController
import ir.mobinyardim.app.characterdetail.R
import ir.mobinyardim.rickandmorty.route_contracts.CharacterDetailRouteContract
import javax.inject.Inject


class CharacterDetailRouteContractImpl @Inject constructor() : CharacterDetailRouteContract {

    override fun show(navController: NavController, characterId: Int) {
        navController.navigate(
            R.id.nav_graph_character_detail,
            args = Bundle().apply {
                putInt(CharacterDetailRouteContract.CHARACTER_ID_KEY, characterId)
            }
        )
    }

}