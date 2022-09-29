package com.example.materialdesignapp.colorAdapter

import android.graphics.Color
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesignapp.ColorModel
import com.example.materialdesignapp.databinding.RvItemColorBinding

class ColorVH(private val binding: RvItemColorBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        color: ColorModel,
        onClick: ( color: ColorModel) -> Unit
    ) = with(binding) {

        binding.ivBackground.isVisible = color.selected
        binding.icCircle.setColorFilter(Color.parseColor(color.hex))
        binding.root.setOnClickListener {
            onClick.invoke(color)
        }
    }
}