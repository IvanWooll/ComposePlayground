package com.fs.composeplayground.data

import kotlinx.coroutines.flow.MutableStateFlow

object TypeRepository {

    private var currentType: Type = Type.None

    val typeFlow = MutableStateFlow(currentType)

    fun updateType(type: Type) {
        currentType = type
        typeFlow.tryEmit(currentType)
    }
}