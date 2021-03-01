package com.renovavision.footballhighlights.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class HighlightDetailsViewModelFactory @Inject constructor(): ViewModelProvider.Factory {

    lateinit var videoUrl: String

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        if (modelClass.isAssignableFrom(HighlightDetailsViewModel::class.java)) {
            HighlightDetailsViewModel(videoUrl) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class [$modelClass]")
        }
}