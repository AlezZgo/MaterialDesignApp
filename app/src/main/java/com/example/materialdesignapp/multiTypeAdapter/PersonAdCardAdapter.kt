package com.example.materialdesignapp.multiTypeAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesignapp.FourthFragmentViewItem
import com.example.materialdesignapp.R
import com.example.materialdesignapp.databinding.CvPersonBinding
import com.example.materialdesignapp.databinding.RvItemAdBinding

class PersonAdCardAdapter : ListAdapter<FourthFragmentViewItem,MultipleViewHolder>(FourthFragmentViewItemDiffUtil()) {

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
            is MultipleViewHolder.PersonViewHolder -> holder.bind(getItem(position) as FourthFragmentViewItem.Person)
            is MultipleViewHolder.AdvertisementViewHolder -> holder.bind(getItem(position) as FourthFragmentViewItem.Advertisement)
        }
    }

    override fun getItemViewType(position: Int): Int = when(getItem(position)){
        is FourthFragmentViewItem.Person -> R.layout.cv_person
        is FourthFragmentViewItem.Advertisement -> R.layout.rv_item_ad
    }

    class FourthFragmentViewItemDiffUtil : AbstractDiffCallback<FourthFragmentViewItem>()

}

