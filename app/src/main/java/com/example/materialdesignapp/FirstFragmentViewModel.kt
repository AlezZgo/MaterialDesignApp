package com.example.materialdesignapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstFragmentViewModel : ViewModel() {

    private val _requested = MutableLiveData(false)
    val requested: LiveData<Boolean> = _requested

    fun changeRequestState() {
        _requested.value = !_requested.value!!
    }
}