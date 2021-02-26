package com.renovavision.footballhighlights.presentation.details

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HighlightDetailsViewModel @Inject constructor() : ViewModel() {

    private val _data: MutableStateFlow<String?> = MutableStateFlow(null)

    val data: StateFlow<String?>
        get() = _data

    init {
//        _data.value = videoUrl
    }
}