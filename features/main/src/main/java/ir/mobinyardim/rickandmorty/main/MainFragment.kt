package ir.mobinyardim.rickandmorty.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ir.mobinyardim.app.main.R
import ir.mobinyardim.rickandmorty.screens.ScreenProvidersStore
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment(

) : Fragment(R.layout.fragment_main) {

    @Inject
    lateinit var  screenProvidersStore: ScreenProvidersStore

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewPager = view.findViewById<ViewPager2>(R.id.viewpager)
        val tabBar = view.findViewById<TabLayout>(R.id.tab_bar)

        viewPager.adapter = ViewPagerAdapter(
            screenProvidersStore = screenProvidersStore,
            fragment = this
        )

        TabLayoutMediator(tabBar, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Characters"
                }
                1 -> {
                    tab.text = "Saved Characters"
                }
            }

        }.attach()
    }
}
