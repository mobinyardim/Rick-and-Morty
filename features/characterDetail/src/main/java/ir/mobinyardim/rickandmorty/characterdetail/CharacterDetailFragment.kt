package ir.mobinyardim.rickandmorty.characterdetail

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dagger.hilt.android.AndroidEntryPoint
import ir.mobinyardim.app.characterdetail.R
import ir.mobinyardim.rickandmorty.characterdetail.viewmodel.CharacterDetailViewModel
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail) {

    private val args by navArgs<CharacterDetailFragmentArgs>()

    @Inject
    lateinit var characterDetailViewModelFactory: CharacterDetailViewModel.Factory

    private val viewModel by viewModels<CharacterDetailViewModel> {
        CharacterDetailViewModel.provideFactory(
            assistedFactory = characterDetailViewModelFactory,
            characterId = args.characterId
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val image = view.findViewById<ImageView>(R.id.image)
        val name = view.findViewById<TextView>(R.id.name)
        val gender = view.findViewById<TextView>(R.id.gender)

        lifecycleScope.launchWhenCreated {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.character.collectLatest {
                    Glide.with(view)
                        .load(it.image)
                        .transform(CenterCrop(), RoundedCorners(25))
                        .into(image)
                    name.text = it.name
                    gender.text = it.gender.name
                }
            }
        }
    }
}