package ir.mobinyardim.app.savedcharacters

import android.os.Bundle
import androidx.fragment.app.Fragment


class SavedCharactersFragment : Fragment(R.layout.fragment_saved_chracters) {


    companion object {
        fun newInstance(): SavedCharactersFragment {
            val args = Bundle()
            return SavedCharactersFragment().apply {
                arguments = args
            }
        }
    }
}