package com.example.materialdesignapp.cardAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.recyclerview.widget.ListAdapter
import com.example.materialdesignapp.Person
import com.example.materialdesignapp.adapter.PersonDiffUtilCallback
import com.example.materialdesignapp.adapter.PersonVH
import com.example.materialdesignapp.databinding.CvPersonBinding
import com.example.materialdesignapp.databinding.RvItemBinding

class PersonCardAdapter(
    private val onCardClick : (person : Person, extras : Navigator.Extras) -> Unit
) : ListAdapter<Person, PersonCardVH>(PersonDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonCardVH {
        val binding = CvPersonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PersonCardVH(binding)
    }

    override fun onBindViewHolder(holder: PersonCardVH, position: Int) {
        val person = getItem(position)
        holder.bind(person,onCardClick)
    }

}