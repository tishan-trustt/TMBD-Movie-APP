package com.example.tmdb.data.repository.movie.Artist

import com.example.tmdb.data.artist.Artist

class ArtistCachedDataSourceImpl:ArtistCachedDataSource {
    private  var artistList = ArrayList<Artist>()
    override suspend fun getMoviesFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveMoviesToCache(artist: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artist)
    }
}