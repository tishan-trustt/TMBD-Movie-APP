package com.example.tmdb.data.repository.movie.TVshow

import com.example.tmdb.data.tv.TvShow
import com.example.tmdb.data.tv.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShowFromApi():Response<TvShowList>
}