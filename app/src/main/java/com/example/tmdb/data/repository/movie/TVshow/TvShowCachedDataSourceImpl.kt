package com.example.tmdb.data.repository.movie.TVshow

import com.example.tmdb.data.tv.TvShow

class TvShowCachedDataSourceImpl:TvShowCachedDataSource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun updateTvShowToCache(tvSHow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvSHow)
    }
}