package ir.mobinyardim.app.characters

import android.os.Bundle
import androidx.fragment.app.Fragment


class CharactersFragment : Fragment(R.layout.fragment_characters) {

    companion object{
        fun newInstance(): CharactersFragment{
            val args = Bundle()
            return CharactersFragment().apply {
                arguments=args
            }
        }
    }
}