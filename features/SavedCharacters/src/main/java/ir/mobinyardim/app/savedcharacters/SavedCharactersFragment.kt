package ir.mobinyardim.app.savedcharacters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.mobinyardim.rickandmorty.characters_common.CharactersAdapter
import com.mobinyardim.rickandmorty.characters_common.VerticalSpaceItemDecoration
import dagger.hilt.android.AndroidEntryPoint
import ir.mobinyardim.app.savedcharacters.viewmodel.SavedCharactersViewModel
import kotlinx.coroutines.flow.collectLatest


@AndroidEntryPoint
class SavedCharactersFragment : Fragment(R.layout.fragment_saved_chracters) {


    companion object {
        fun newInstance(): SavedCharactersFragment {
            val args = Bundle()
            return SavedCharactersFragment().apply {
                arguments = args
            }
        }
    }

    private val viewModel by viewModels<SavedCharactersViewModel>()
    private val adapter = CharactersAdapter(
        onItemClicked = {

        },
        onSaveButtonClicked = {
            if(it.isSaved){
                viewModel.unSaveCharacter(it)
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
                viewModel.savedCharacters.collectLatest {
                    adapter.submitData(it)
                }
            }
        }
    }
}