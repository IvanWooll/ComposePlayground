package com.fs.composeplayground.viewmodel

import androidx.lifecycle.ViewModel
import com.fs.composeplayground.data.NamesRepository

class AddNameViewModel : ViewModel() {

    fun onNameSubmitted(name: String) {
        println(name)
        NamesRepository.addName(name)
    }
}