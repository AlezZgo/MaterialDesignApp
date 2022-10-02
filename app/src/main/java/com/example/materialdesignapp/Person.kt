package com.example.materialdesignapp

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(val name : String, val salaryInDollars : Int, @DrawableRes val iconId : Int) : Parcelable