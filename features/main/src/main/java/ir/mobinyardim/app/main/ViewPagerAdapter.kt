package ir.mobinyardim.app.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ir.mobinyardim.app.screens.ScreenProvidersStore

class ViewPagerAdapter(
    fragment: Fragment,
    screenProvidersStore: ScreenProvidersStore
) : FragmentStateAdapter(fragment) {

    private val fragments = arrayListOf(
        screenProvidersStore.charactersFragmentProvider.newInstance(),
        screenProvidersStore.savedCharactersFragmentProvider.newInstance()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}