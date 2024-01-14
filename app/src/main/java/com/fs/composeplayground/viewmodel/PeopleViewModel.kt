package com.fs.composeplayground.viewmodel

import androidx.lifecycle.ViewModel
import com.fs.composeplayground.data.NamesRepository
import com.fs.composeplayground.data.TypeRepository
import com.fs.composeplayground.ui.composables.PersonItemState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine

class PeopleViewModel : ViewModel() {

    fun onPersonClicked(person: PersonItemState) {
        println(person)
    }

    val peopleState = NamesRepository.namesFlow.combine(TypeRepository.typeFlow) { strings, currentType ->
        strings.map {
            PersonItemState(name = it, type = currentType)
        }
    }

    val state = NamesRepository.namesFlow.combine(TypeRepository.typeFlow) { strings, currentType ->
        strings.map {
            PersonItemState(name = it, type = currentType)
        }
    }

}