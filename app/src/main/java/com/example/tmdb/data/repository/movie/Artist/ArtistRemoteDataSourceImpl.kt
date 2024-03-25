package com.example.tmdb.data.repository.movie.Artist

import com.example.tmdb.data.api.TMDBservice
import com.example.tmdb.data.artist.Artist
import com.example.tmdb.data.artist.ArtistList
import com.example.tmdb.roomDB.ArtistDAO
import okhttp3.Response

class ArtistRemoteDataSourceImpl(
    private val tmbdService:TMDBservice,
    private val apiKey:String
) :ArtistRemoteDataSource{
    override suspend fun getArtists(): retrofit2.Response<ArtistList> {
        return tmbdService.getPopularPerson(apiKey)
    }
}