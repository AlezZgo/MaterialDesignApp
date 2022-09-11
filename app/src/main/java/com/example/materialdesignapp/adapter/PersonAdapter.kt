package com.example.materialdesignapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.materialdesignapp.Person
import com.example.materialdesignapp.R
import com.example.materialdesignapp.databinding.RvItemBinding

class PersonAdapter : ListAdapter<Person, PersonVH>(PersonDiffUtilCallback()) {
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