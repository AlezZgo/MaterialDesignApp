package com.example.materialdesignapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.materialdesignapp.FourthFragmentViewItem
import com.example.materialdesignapp.databinding.RvItemBinding

class PersonAdapter : ListAdapter<FourthFragmentViewItem.Person, PersonVH>(PersonDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonVH {
        val binding = RvItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PersonVH(binding)
    }

    override fun onBindViewHolder(holder: PersonVH, position: Int) {
        val person = getItem(position)
        holder.bind(person)
    }

}