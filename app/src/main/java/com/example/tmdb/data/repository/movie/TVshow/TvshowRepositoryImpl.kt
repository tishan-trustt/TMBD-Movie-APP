package com.example.tmdb.data.repository.movie.TVshow

import android.util.Log
import com.example.tmdb.data.repository.movie.Artist.ArtistCachedDataSource
import com.example.tmdb.data.repository.movie.Artist.ArtistLocalDataSource
import com.example.tmdb.data.repository.movie.Artist.ArtistRemoteDataSource
import com.example.tmdb.data.tv.TvShow
import com.example.tmdb.domain.repository.TvShowRepository

class TvshowRepositoryImpl(
    private val tvShowCachedDataSource: TvShowCachedDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource
):TvShowRepository {
    override suspend fun getTvSHows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.updateTvShowtoDB(newListOfTvShows)
        tvShowCachedDataSource.updateTvShowToCache(newListOfTvShows)
        return newListOfTvShows
    }

    suspend fun getTvShowsFromApi():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            val response = tvShowRemoteDataSource.getTvShowFromApi()
            val body = response.body()
            if(body!=null){
                tvShowList = body.tvShows
            }
        }catch (e:Exception){
            Log.i("MYTAG",e.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowFromDB():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch (e:Exception){
            Log.i("MYTAG",e.message.toString())
        }
        if(tvShowList.size>0){
            return tvShowList
        }
        else{
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.updateTvShowtoDB(tvShowList)
        }
        return tvShowList
    }

    suspend fun getTvShowsFromCache():List<TvShow>{
        lateinit var tvShowList : List<TvShow>
        try {
            tvShowList = tvShowCachedDataSource.getTvShowsFromCache()
        }catch (e:Exception){
            Log.i("MYTAG",e.message.toString())
        }
        if(tvShowList.size>0){
            return tvShowList
        }
        else{
            tvShowList = getTvShowFromDB()
            tvShowCachedDataSource.updateTvShowToCache(tvShowList)
        }
        return tvShowList
    }
}