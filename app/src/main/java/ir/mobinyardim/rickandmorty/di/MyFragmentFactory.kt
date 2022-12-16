package ir.mobinyardim.rickandmorty.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import ir.mobinyardim.rickandmorty.characterdetail.CharacterDetailFragment
import ir.mobinyardim.app.main.MainFragment
import ir.mobinyardim.rickandmorty.screens.ScreenProvidersStore
import javax.inject.Inject
import kotlin.time.ExperimentalTime

@ExperimentalTime
class MyFragmentFactory @Inject constructor(
    private val screenProvidersStore: ScreenProvidersStore
) : FragmentFactory() {


    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            MainFragment::class.java.name -> {
                MainFragment(screenProvidersStore = screenProvidersStore)
            }
            CharacterDetailFragment::class.java.name -> {
                CharacterDetailFragment()
            }
            else -> super.instantiate(classLoader, className)
        }
    }
}