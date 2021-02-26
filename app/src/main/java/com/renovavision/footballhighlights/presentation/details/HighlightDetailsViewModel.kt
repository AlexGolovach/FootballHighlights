package com.renovavision.footballhighlights.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HighlightDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _data: MutableStateFlow<String?> = MutableStateFlow(null)

    val data: StateFlow<String?>
        get() = _data

    init {
        _data.value = savedStateHandle.get<String>("videoUrl")
    }
}