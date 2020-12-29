package com.renovavision.footballhighlights.data

import retrofit2.http.GET

interface HighlightsService {

    @GET("video-api/v1/")
    suspend fun loadMatches(): List<Match>
}