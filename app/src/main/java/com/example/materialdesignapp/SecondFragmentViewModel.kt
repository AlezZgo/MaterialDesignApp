package com.example.materialdesignapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondFragmentViewModel : ViewModel() {

    private val _colors = MutableLiveData<List<ColorModel>>()
    val colors: LiveData<List<ColorModel>> = _colors

    fun setUpColors(colorHexList : List<String>){
        _colors.postValue(colorHexList.mapIndexed { index, colorHex ->
            ColorModel(colorHex,index==0)
        })
    }

    fun setSelectedColor(color : ColorModel) {
        _colors.postValue(
            _colors.value?.toList()?.map {
                if (it.hex==color.hex)  ColorModel(color.hex,true)
                else ColorModel(it.hex,false) }
        )
    }

}