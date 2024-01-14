package com.fs.composeplayground.viewmodel

import androidx.lifecycle.ViewModel
import com.fs.composeplayground.data.Type
import com.fs.composeplayground.data.TypeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TypeViewModel : ViewModel() {

    fun onTypeChanged(type: Type) {
        TypeRepository.updateType(type)
    }

    val type: StateFlow<Type> = TypeRepository.typeFlow
}