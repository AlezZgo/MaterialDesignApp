package com.example.materialdesignapp

import androidx.annotation.DrawableRes

data class Person(val name : String, val salaryInDollars : Int, @DrawableRes val iconId : Int)