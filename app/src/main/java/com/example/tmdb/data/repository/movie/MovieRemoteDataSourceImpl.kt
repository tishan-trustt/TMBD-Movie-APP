package com.example.tmdb.data.repository.movie

import com.example.tmdb.data.api.TMDBservice
import com.example.tmdb.data.movie.MovieList
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmdBservice: TMDBservice,private val apiKey:String):
    MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdBservice.getPopularMovies(apiKey)


}