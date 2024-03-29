package com.example.materialdesignapp.cardAdapter

import android.view.animation.AnimationUtils
import androidx.core.view.ViewCompat
import androidx.navigation.Navigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.example.materialdesignapp.FourthFragmentViewItem
import com.example.materialdesignapp.R
import com.example.materialdesignapp.databinding.CvPersonBinding

class PersonCardVH(
    private val binding: CvPersonBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        person: FourthFragmentViewItem.Person,
        onCardClick: (person: FourthFragmentViewItem.Person, extras: Navigator.Extras) -> Unit
    ) = with(binding) {

        val context = binding.root.context
        btnName.text = person.name

        binding.root.startAnimation(
            AnimationUtils.loadAnimation(
                context,
                R.anim.rv_item_scroll_enter_anim
            )
        )

        val extras = FragmentNavigatorExtras(
            binding.ivAvatar to "iv_avatar",
            binding.cvCont to "cv_cont",
            binding.btnName to "btn_name",
        )

        binding.btnName.setOnClickListener {
            onCardClick.invoke(person, extras)
        }
        ViewCompat.setTransitionName(binding.ivAvatar, "${person.name}avatar")
        ViewCompat.setTransitionName(binding.cvCont, "${person.name}cont")
        ViewCompat.setTransitionName(binding.btnName, "${person.name}btn")

    }
}