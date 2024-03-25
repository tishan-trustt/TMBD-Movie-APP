package com.example.tmdb.data.repository.movie.TVshow

import com.example.tmdb.data.tv.TvShow
import com.example.tmdb.roomDB.TvshowsDAO

class TvShowLocalDataSourceImpl(
    private val tvshowsDAO: TvshowsDAO
):TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvshowsDAO.getTvShows()
    }

    override suspend fun updateTvShowtoDB(tvShow: List<TvShow>) {
        tvshowsDAO.saveTvShows(tvShow)
    }

    override suspend fun clearAll() {
        tvshowsDAO.deleteAllTvShows()
    }
}