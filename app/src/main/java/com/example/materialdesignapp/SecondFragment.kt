package com.example.materialdesignapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.materialdesignapp.colorAdapter.ColorAdapter
import com.example.materialdesignapp.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    val vm by viewModels<SecondFragmentViewModel>()
    private val colorAdapter by lazy {
        ColorAdapter {
            vm.setSelectedColor(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.setUpColors(resources.getStringArray(R.array.color_set).toList())

        binding.rvColors.adapter = colorAdapter

        vm.colors.observe(viewLifecycleOwner) {
            colorAdapter.submitList(it)
            binding.ivCurvimeter.setColorFilter(Color.parseColor(it.filter { it.selected }
                .first().hex))
        }

    }


}