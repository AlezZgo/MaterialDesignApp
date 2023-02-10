package com.example.materialdesignapp

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.materialdesignapp.FourthFragmentViewItem.Advertisement
import com.example.materialdesignapp.FourthFragmentViewItem.Person
import kotlinx.parcelize.Parcelize

class FourthViewModel : ViewModel() {

    val personAdCards = MutableLiveData(
        listOf(
            Person("Alex", 1000, R.drawable.ic_alex),
            Person("Andrew", 800, R.drawable.ic_andrew),
            Person("Kiara", 1200, R.drawable.ic_kiara),
            Person("Maryann", 1300, R.drawable.ic_maryann),
            Person("Raf", 1100, R.drawable.ic_raf),
            Advertisement("New TV"),
            Person("Alex", 1000, R.drawable.ic_alex),
            Person("Andrew", 800, R.drawable.ic_andrew),
            Person("Kiara", 1200, R.drawable.ic_kiara),
            Person("Maryann", 1300, R.drawable.ic_maryann),
            Person("Raf", 1100, R.drawable.ic_raf),
            Advertisement("New Book"),
            Person("Alex", 1000, R.drawable.ic_alex),
            Person("Andrew", 800, R.drawable.ic_andrew),
            Person("Kiara", 1200, R.drawable.ic_kiara),
            Person("Maryann", 1300, R.drawable.ic_maryann),
            Person("Raf", 1100, R.drawable.ic_raf),
            Advertisement("New Microphone"),
        )
    )
}

sealed class FourthFragmentViewItem {

    data class Advertisement(
        val message: String
    ) : FourthFragmentViewItem()

    @Parcelize
    data class Person(
        val name: String,
        val salaryInDollars: Int,
        @DrawableRes val iconId: Int
    ) : Parcelable, FourthFragmentViewItem()

}

