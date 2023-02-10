package com.example.materialdesignapp.multiTypeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesignapp.FourthFragmentViewItem
import com.example.materialdesignapp.R
import com.example.materialdesignapp.databinding.CvPersonBinding
import com.example.materialdesignapp.databinding.RvItemAdBinding

class PersonAdCardAdapter : RecyclerView.Adapter<MultipleViewHolder>() {

    var items = listOf<FourthFragmentViewItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultipleViewHolder = when(viewType){
        R.layout.cv_person -> MultipleViewHolder.PersonViewHolder(
            CvPersonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        R.layout.rv_item_ad -> MultipleViewHolder.AdvertisementViewHolder(
            RvItemAdBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        else -> throw IllegalArgumentException("Invalid ViewType Provided")
    }

    override fun onBindViewHolder(holder: MultipleViewHolder, position: Int) {
        when(holder){
            is MultipleViewHolder.PersonViewHolder -> holder.bind(items[position] as FourthFragmentViewItem.Person)
            is MultipleViewHolder.AdvertisementViewHolder -> holder.bind(items[position] as FourthFragmentViewItem.Advertisement)
        }
    }

    override fun getItemViewType(position: Int): Int = when(items[position]){
        is FourthFragmentViewItem.Person -> R.layout.cv_person
        is FourthFragmentViewItem.Advertisement -> R.layout.rv_item_ad
    }

    override fun getItemCount(): Int = items.size

}