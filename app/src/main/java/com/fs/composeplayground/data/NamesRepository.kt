package com.fs.composeplayground.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

object NamesRepository {
    private val names: MutableList<String> = mutableListOf()

    private val _namesFlow: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())
    val namesFlow: Flow<List<String>> = _namesFlow

    fun addName(name: String) {
        names.add(name)
        _namesFlow.tryEmit(names)
    }
}