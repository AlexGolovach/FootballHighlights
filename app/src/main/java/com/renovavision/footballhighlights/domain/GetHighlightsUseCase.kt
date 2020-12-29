package com.renovavision.footballhighlights.domain

import com.renovavision.footballhighlights.data.Repository
import javax.inject.Inject

class GetHighlightsUseCase @Inject constructor(private val repository: Repository) {

    fun invoke() = repository.getHighlights()
}