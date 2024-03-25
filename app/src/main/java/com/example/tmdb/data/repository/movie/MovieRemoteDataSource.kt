package com.example.tmdb.data.repository.movie

import com.example.tmdb.data.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies():Response<MovieList>
}