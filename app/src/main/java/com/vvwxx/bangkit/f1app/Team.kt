package com.vvwxx.bangkit.f1app

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val name: String,
    val description: String,
    val photo: Int,
    val fullTeamName: String,
    val base: String,
    val teamChief: String,
    val chassis: String,
    val powerUnit: String,
    val firstTeamEntry: String,
    val worldChampionships: String
) : Parcelable