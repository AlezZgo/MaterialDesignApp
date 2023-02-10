package com.example.materialdesignapp.multiTypeAdapter

sealed class MultipleAdapterModel{

    data class Employee(
        val name : String
    ) : MultipleAdapterModel()

    data class Advertisement(
        val text : String
    ) : MultipleAdapterModel()

}