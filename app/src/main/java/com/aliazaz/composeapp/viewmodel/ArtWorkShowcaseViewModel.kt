package com.aliazaz.composeapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ArtWorkShowcaseViewModel : ViewModel() {

    private val _artWorkItemIndex = MutableStateFlow(0)
    val artWorkItemIndex = _artWorkItemIndex.asStateFlow()

    fun nextClick() {
        _artWorkItemIndex.value++
    }

    fun previousClick() {
        _artWorkItemIndex.value--
    }
}