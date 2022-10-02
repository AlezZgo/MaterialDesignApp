package com.example.materialdesignapp

import android.os.Bundle
import android.transition.ChangeBounds
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.materialdesignapp.databinding.FragmentSecondBinding
import com.example.materialdesignapp.databinding.FragmentThirdBinding


class ThirdFragment : Fragment() {

    private lateinit var binding: FragmentThirdBinding

    val vm by viewModels<ThirdFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        sharedElementEnterTransition = ChangeBounds().apply {
            duration = 400
        }
        return binding.root
    }

}