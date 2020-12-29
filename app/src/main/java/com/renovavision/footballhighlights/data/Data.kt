package com.renovavision.footballhighlights.data

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Match(
    val title: String,
    val embed: String,
    val url: String,
    val thumbnail: String,
    val date: String,
    val side1: Team,
    val side2: Team,
    val competition: Competition,
    val videos: List<Video>
): Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Team(
    val name: String,
    val url: String
): Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Competition(
    val name: String,
    val id: String,
    val url: String
): Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Video(
    val title: String,
    val embed: String
): Parcelable