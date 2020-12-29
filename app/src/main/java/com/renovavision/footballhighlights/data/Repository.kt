package com.renovavision.footballhighlights.data

import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val service: HighlightsService) {

    fun getHighlights() = flow {
        emit(service.loadMatches())
    }
}