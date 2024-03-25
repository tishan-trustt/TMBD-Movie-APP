package com.example.tmdb.data.repository.movie.TVshow

import com.example.tmdb.data.api.TMDBservice
import com.example.tmdb.data.tv.TvShowList
import retrofit2.Response

class TvShowRemoteDataSourceImpl(private val tmdBservice: TMDBservice
,private val apiKey:String):TvShowRemoteDataSource {
    override suspend fun getTvShowFromApi(): Response<TvShowList> {
        return tmdBservice.getPopularTvShows(apiKey)
    }
}