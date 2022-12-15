package ir.mobinyardim.app.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.mobinyardim.rickandmorty.characters_common.CharactersAdapter
import dagger.hilt.android.AndroidEntryPoint
import ir.mobinyardim.app.characters.viewmodel.CharactersViewModel
import kotlinx.coroutines.flow.collectLatest


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

    private val viewModel by viewModels<CharactersViewModel>()
    private val adapter = CharactersAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recycler = view.findViewById<RecyclerView>(R.id.characters_recycler)
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