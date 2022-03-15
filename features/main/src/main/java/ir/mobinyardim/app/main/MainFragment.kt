package ir.mobinyardim.app.main

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import ir.mobinyardim.app.main.databinding.FragmentMainBinding
import ir.mobinyardim.app.screens.ScreenProvidersStore

class MainFragment(
    private val screenProvidersStore: ScreenProvidersStore
) : Fragment(R.layout.fragment_main) {


    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = DataBindingUtil.bind(view)!!

        binding.viewpager.adapter = ViewPagerAdapter(
            screenProvidersStore = screenProvidersStore,
            fragment = this
        )

        TabLayoutMediator(binding.tabBar, binding.viewpager) { tab, position ->
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
