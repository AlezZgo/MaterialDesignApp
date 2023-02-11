package com.example.materialdesignapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.materialdesignapp.databinding.FragmentFourthBinding
import com.example.materialdesignapp.multiTypeAdapter.PersonAdCardAdapter

class FourthFragment : Fragment() {

    private val viewModel by viewModels<FourthViewModel>()
    private lateinit var binding : FragmentFourthBinding

    private val adapter by lazy {
        PersonAdCardAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFourthBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter
        viewModel.personAdCards.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        binding.refreshButton.setOnClickListener {
            viewModel.personAdCards.postValue(
                viewModel.personAdCards.value?.reversed()
            )
        }
        binding.getBtn.setOnClickListener {
            viewModel.fetch()
        }
    }

}