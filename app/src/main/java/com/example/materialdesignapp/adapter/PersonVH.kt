package com.example.materialdesignapp.adapter

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.materialdesignapp.Person
import com.example.materialdesignapp.R
import com.example.materialdesignapp.databinding.RvItemBinding

class PersonVH(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        person: Person
    ) = with(binding) {

        titleTextView.text = person.name
        contentTextView.text = person.salaryInDollars.toString()

        Glide.with(binding.iv.context)
            .load(person.iconId)
            .into(binding.iv)

    }
}