package com.mobinyardim.rickandmorty.characters_common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.mobinyardim.app.models.Character

class CharactersAdapter(

) : PagingDataAdapter<Character, CharactersAdapter.CharacterViewHolder>(CharacterDiffUtil) {

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        holder.bindTo(character)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder.create(parent)
    }


    class CharacterViewHolder private constructor(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        companion object {
            fun create(root: ViewGroup): CharacterViewHolder {
                return CharacterViewHolder(
                    LayoutInflater.from(root.context).inflate(R.layout.item_character, root, false)
                )
            }
        }

        fun bindTo(character: Character?) {
            val image = itemView.findViewById<ImageView>(R.id.image)
            val name = itemView.findViewById<TextView>(R.id.name)
            val gender = itemView.findViewById<TextView>(R.id.gender)
            if (character != null) {
                name.text = character.name
                gender.text = character.gender.name
                Glide.with(itemView).load(character.image).into(image)
            }
        }
    }
}

object CharacterDiffUtil : DiffUtil.ItemCallback<Character>() {

    override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
        return oldItem == newItem
    }

}