package com.example.materialdesignapp.cardAdapter

import androidx.core.view.ViewCompat
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.materialdesignapp.Person
import com.example.materialdesignapp.databinding.CvPersonBinding

class PersonCardVH(
    private val binding: CvPersonBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(
        person: Person,
        onCardClick : (person : Person, extras : Navigator.Extras) -> Unit
    ) = with(binding) {

        btnName.text = person.name

        val extras =  FragmentNavigatorExtras(
            binding.ivAvatar to "iv_avatar",
            binding.cvCont to "cv_cont",
            binding.btnName to "btn_name",
        )

        binding.btnName.setOnClickListener {
            onCardClick.invoke(person,extras)
        }
        ViewCompat.setTransitionName(binding.ivAvatar,"${person.name}avatar")
        ViewCompat.setTransitionName(binding.cvCont, "${person.name}cont")
        ViewCompat.setTransitionName(binding.btnName, "${person.name}btn")
        Glide.with(binding.ivAvatar.context)
            .load(person.iconId)
            .into(binding.ivAvatar)

    }
}