package com.example.materialdesignapp

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.materialdesignapp.FourthFragmentViewItem.Person
import com.example.materialdesignapp.multiTypeAdapter.Match
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.parcelize.Parcelize

class FourthViewModel : ViewModel() {

    val personAdCards = MutableLiveData(emptyList<FourthFragmentViewItem>())

    fun fetch() {

        val ads = viewModelScope.async {
            delay(3000)
            return@async listOf(
                FourthFragmentViewItem.Advertisement("New TV", 6),
                FourthFragmentViewItem.Advertisement("New Book", 12),
                FourthFragmentViewItem.Advertisement("New Microphone", 18),
            )
        }

        val persons = viewModelScope.async {
            delay(1000)
            return@async listOf(
                Person("Alex", 1000, R.drawable.ic_alex, 1),
                Person("Andrew", 800, R.drawable.ic_andrew, 2),
                Person("Kiara", 1200, R.drawable.ic_kiara, 3),
                Person("Maryann", 1300, R.drawable.ic_maryann, 4),
                Person("Raf", 1100, R.drawable.ic_raf, 5),
                Person("Alex", 1000, R.drawable.ic_alex, 7),
                Person("Andrew", 800, R.drawable.ic_andrew, 8),
                Person("Kiara", 1200, R.drawable.ic_kiara, 9),
                Person("Maryann", 1300, R.drawable.ic_maryann, 10),
                Person("Raf", 1100, R.drawable.ic_raf, 11),
                Person("Alex", 1000, R.drawable.ic_alex, 13),
                Person("Andrew", 800, R.drawable.ic_andrew, 14),
                Person("Kiara", 1200, R.drawable.ic_kiara, 15),
                Person("Maryann", 1300, R.drawable.ic_maryann, 16),
                Person("Raf", 1100, R.drawable.ic_raf, 17),
            )
        }

        viewModelScope.launch {
            personAdCards.postValue(
                persons.await().chunked(6).zip(ads.await()){  listOfStr,b->
                    if(listOfStr.size<6)
                        listOfStr
                    else
                        listOfStr + b
                }.flatten()
            )
        }
    }

}

//listOf(

//

//
//)

sealed class FourthFragmentViewItem : Match<FourthFragmentViewItem> {

    abstract val id: Int

    data class Advertisement(
        val message: String,
        override val id: Int = System.currentTimeMillis().toInt(),
    ) : FourthFragmentViewItem() {
        override fun matchesId(model: FourthFragmentViewItem): Boolean {
            return model.id == id
        }

        override fun matches(model: FourthFragmentViewItem): Boolean {
            return model == this
        }
    }

    @Parcelize
    data class Person(
        val name: String,
        val salaryInDollars: Int,
        @DrawableRes val iconId: Int,
        override val id: Int = System.currentTimeMillis().toInt(),
    ) : Parcelable, FourthFragmentViewItem() {
        override fun matchesId(model: FourthFragmentViewItem): Boolean {
            return model.id == id
        }

        override fun matches(model: FourthFragmentViewItem): Boolean {
            return model == this
        }
    }

}

