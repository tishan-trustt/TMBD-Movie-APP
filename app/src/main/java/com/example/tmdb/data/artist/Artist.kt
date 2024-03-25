package com.example.tmdb.data.artist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_artist")
data class Artist(
    val adult: Boolean,
    @PrimaryKey
    val gender: Int,
    val id: Int,

    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String
)