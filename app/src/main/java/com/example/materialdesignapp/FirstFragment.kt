package com.example.materialdesignapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesignapp.adapter.PersonAdapter
import com.example.materialdesignapp.databinding.FragmentFirstBinding
import io.github.g00fy2.quickie.QRResult
import io.github.g00fy2.quickie.ScanQRCode

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    private val persons = listOf<Person>(
        Person("Alex",1000,R.drawable.ic_alex),
        Person("Andrew",800,R.drawable.ic_andrew),
        Person("Kiara",1200,R.drawable.ic_kiara),
        Person("Maryann",1300,R.drawable.ic_maryann),
        Person("Raf",1100,R.drawable.ic_raf)
    )

    private val adapter by lazy {
        PersonAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)


        binding.recyclerView.adapter = adapter

        adapter.submitList(persons)

        return binding.root
    }

}