package com.example.tmdb.data.api

import com.example.tmdb.data.artist.ArtistList
import com.example.tmdb.data.movie.MovieList
import com.example.tmdb.data.tv.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBservice {

    @GET("/movie/popular")
    suspend fun getPopularMovies(@Query("api_key")apiKey :String):Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key")apiKey:String):Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularPerson(@Query("api_key")apiKey:String):Response<ArtistList>
}