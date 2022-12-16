package ir.mobinyardim.rickandmorty.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import ir.mobinyardim.rickandmorty.characters_common.CharactersAdapter
import ir.mobinyardim.rickandmorty.characters_common.VerticalSpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import ir.mobinyardim.app.characters.R
import ir.mobinyardim.rickandmorty.characters.viewmodel.CharactersViewModel
import ir.mobinyardim.rickandmorty.route_contracts.CharacterDetailRouteContract
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject


@AndroidEntryPoint
class CharactersFragment : Fragment(R.layout.fragment_characters) {

    companion object {
        fun newInstance(): CharactersFragment {
            val args = Bundle()
            return CharactersFragment().apply {
                arguments = args
            }
        }
    }

    @Inject
    lateinit var charactersRouteContract: CharacterDetailRouteContract

    private val viewModel by viewModels<CharactersViewModel>()
    private val adapter = CharactersAdapter(
        onItemClicked = {
            charactersRouteContract.show(findNavController(), it.id)
        },
        onSaveButtonClicked = {
            if (it.isSaved) {
                viewModel.unSaveCharacter(character = it)
            } else {
                viewModel.saveCharacter(character = it)
            }
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recycler = view.findViewById<RecyclerView>(R.id.characters_recycler)
        recycler.addItemDecoration(
            VerticalSpaceItemDecoration(
                resources.getDimension(com.mobinyardim.rickandmorty.characters_common.R.dimen.item_vertical_space)
                    .toInt()
            )
        )
        recycler.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.characters.collectLatest {
                    adapter.submitData(it)
                }
            }
        }
    }
}