package com.example.materialdesignapp

import android.graphics.Color
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.materialdesignapp.cardAdapter.PersonCardAdapter
import com.example.materialdesignapp.cardAdapter.PersonCardVH
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
    private val cardsAdapter by lazy {
        PersonCardAdapter{ person,extras->
            findNavController().navigate(SecondFragmentDirections.actionNavigationFragmentSecondToPersonCardFragment(person),extras)
        }
    }

    private val persons = listOf<Person>(
        Person("Alex",1000,R.drawable.ic_alex),
        Person("Andrew",800,R.drawable.ic_andrew),
        Person("Kiara",1200,R.drawable.ic_kiara),
        Person("Maryann",1300,R.drawable.ic_maryann),
        Person("Raf",1100,R.drawable.ic_raf),
        Person("Alex",1000,R.drawable.ic_alex),
        Person("Andrew",800,R.drawable.ic_andrew),
        Person("Kiara",1200,R.drawable.ic_kiara),
        Person("Maryann",1300,R.drawable.ic_maryann),
        Person("Raf",1100,R.drawable.ic_raf),
        Person("Alex",1000,R.drawable.ic_alex),
        Person("Andrew",800,R.drawable.ic_andrew),
        Person("Kiara",1200,R.drawable.ic_kiara),
        Person("Maryann",1300,R.drawable.ic_maryann),
        Person("Raf",1100,R.drawable.ic_raf)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postponeEnterTransition()
        vm.setUpColors(resources.getStringArray(R.array.color_set).toList())

        binding.rvColors.adapter = colorAdapter

        vm.colors.observe(viewLifecycleOwner) {

            colorAdapter.submitList(it)

            binding.ivCurvimeter.setColorFilter(
                Color.parseColor(it.filter { it.selected }.first().hex)
            )
        }

        binding.rvCards.adapter = cardsAdapter

        cardsAdapter.submitList(persons)

        (view.parent as? ViewGroup)?.doOnPreDraw {
            startPostponedEnterTransition()
        }

        binding.ivCurvimeter.setOnClickListener {
            val extras = FragmentNavigatorExtras(
                binding.ivCurvimeter to "iv_cur",
            )
            findNavController().navigate(SecondFragmentDirections.actionNavigationFragmentSecondToThirdFragment(),extras)
        }



    }


}