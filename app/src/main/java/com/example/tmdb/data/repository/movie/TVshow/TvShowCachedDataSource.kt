package com.example.tmdb.data.repository.movie.TVshow

import com.example.tmdb.data.tv.TvShow

interface TvShowCachedDataSource {

     suspend fun getTvShowsFromCache():List<TvShow>
     suspend fun updateTvShowToCache(tvSHow:List<TvShow>)
}