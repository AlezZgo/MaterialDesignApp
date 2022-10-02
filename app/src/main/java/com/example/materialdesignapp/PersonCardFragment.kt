package com.example.materialdesignapp

import android.os.Bundle
import android.transition.ChangeBounds
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.materialdesignapp.databinding.FragmentPersonCardBinding


class PersonCardFragment : Fragment() {

    val args by navArgs<PersonCardFragmentArgs>()
    private lateinit var binding: FragmentPersonCardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentPersonCardBinding.inflate(layoutInflater, container, false)
        sharedElementEnterTransition = ChangeBounds().apply {
            duration = 400
        }
        Glide.with(binding.ivAvatar.context)
            .load(args.person.iconId)
            .into(binding.ivAvatar)
        binding.btnName.text= args.person.name
        return binding.root
    }

}