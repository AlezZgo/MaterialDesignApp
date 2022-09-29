package com.example.materialdesignapp.colorAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.materialdesignapp.ColorModel
import com.example.materialdesignapp.databinding.RvItemColorBinding

class ColorAdapter(
    private val onClick: ( colorModel : ColorModel) -> Unit
) : ListAdapter<ColorModel, ColorVH>(ColorDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorVH {
        val binding = RvItemColorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ColorVH(binding)
    }

    override fun onBindViewHolder(holder: ColorVH, position: Int) {
        val color = getItem(position)
        holder.bind(color, onClick)
    }

}
