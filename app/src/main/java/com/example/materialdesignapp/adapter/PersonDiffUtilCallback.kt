package com.example.materialdesignapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.materialdesignapp.Person

class PersonDiffUtilCallback : DiffUtil.ItemCallback<Person>() {

    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
        return oldItem == newItem
    }
}