package com.example.tmdb.data.repository.movie.Artist

import com.example.tmdb.data.artist.Artist
import com.example.tmdb.data.movie.Movie

interface ArtistCachedDataSource {
    suspend fun getMoviesFromCache():List<Artist>
    suspend fun saveMoviesToCache(artist:List<Artist>)
}