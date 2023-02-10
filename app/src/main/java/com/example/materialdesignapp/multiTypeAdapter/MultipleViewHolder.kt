package com.example.materialdesignapp.multiTypeAdapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.example.materialdesignapp.FourthFragmentViewItem
import com.example.materialdesignapp.databinding.CvPersonBinding
import com.example.materialdesignapp.databinding.RvItemAdBinding

sealed class MultipleViewHolder(binding: ViewBinding) : ViewHolder(binding.root) {

    class AdvertisementViewHolder(private val binding: RvItemAdBinding) :
        MultipleViewHolder(binding) {
        fun bind(ad: FourthFragmentViewItem.Advertisement) {
            binding.tvTitle.text = ad.message
        }
    }

    class PersonViewHolder(private val binding: CvPersonBinding) : MultipleViewHolder(binding) {
        fun bind(person: FourthFragmentViewItem.Person) {
            binding.btnName.text = person.name
            binding.ivAvatar.setImageResource(person.iconId)
        }
    }


}