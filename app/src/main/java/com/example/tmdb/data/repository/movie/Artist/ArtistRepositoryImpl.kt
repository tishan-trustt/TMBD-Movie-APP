package com.example.tmdb.data.repository.movie.Artist

import android.util.Log
import com.example.tmdb.data.artist.Artist
import com.example.tmdb.data.movie.Movie
import com.example.tmdb.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistCachedDataSource: ArtistCachedDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource
):ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newArtistList = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistToDB(newArtistList)
        artistCachedDataSource.saveMoviesToCache(newArtistList)
        return newArtistList
    }

    suspend fun getArtistFromApi():List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        }catch (e:Exception){
            Log.i("MYTAG",e.message.toString())
        }
        return artistList
    }



    suspend fun getArtistFromDB():List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistFromDB()
        }catch (e:Exception){
            Log.i("MYTAG",e.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }
        else{
            artistList = getArtistFromApi()
            artistLocalDataSource.saveArtistToDB(artistList)

        }
        return artistList
    }

    suspend fun getArtistFromCache():List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistCachedDataSource.getMoviesFromCache()
        }catch (e:Exception){
            Log.i("MYTAG",e.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }
        else{
            artistList = getArtistFromDB()
            artistCachedDataSource.saveMoviesToCache(artistList)

        }
        return artistList
    }
}