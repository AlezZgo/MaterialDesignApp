package com.example.materialdesignapp.colorAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.materialdesignapp.ColorModel
import com.example.materialdesignapp.Person

class ColorDiffUtilCallback : DiffUtil.ItemCallback<ColorModel>() {

    override fun areItemsTheSame(oldItem: ColorModel, newItem: ColorModel): Boolean {
        return oldItem.hex == newItem.hex
    }

    override fun areContentsTheSame(oldItem: ColorModel, newItem: ColorModel): Boolean {
        return oldItem == newItem
    }
}