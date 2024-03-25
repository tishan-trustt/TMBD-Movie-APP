package com.example.tmdb.data.repository.movie

import android.util.Log
import com.example.tmdb.data.movie.Movie
import com.example.tmdb.domain.repository.MovieRepository

class MovieRepositaryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCachedDataSource: MovieCacheDataSource
):MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newMovieList = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDB(newMovieList)
        movieCachedDataSource.saveMoviesToCache(newMovieList)
        return newMovieList

    }

    suspend fun getMoviesFromApi():List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if(body != null){
                movieList = body.movies
            }

        }
        catch (e:Exception){
            Log.i("MYTAG",e.message.toString())
        }
        return movieList
    }

    suspend fun getMoviesFromDb():List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        }
        catch (e:Exception){
            Log.i("MYTAG",e.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }
        else{
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache():List<Movie>{

        lateinit var movieList:List<Movie>
        try {
            movieList = movieCachedDataSource.getMoviesFromCache()
        }catch (e:Exception){
            Log.i("MYTAG",e.message.toString())
        }
        if(movieList.size>0){
            return movieList
        }
        else{
            movieList = getMoviesFromDb()
            movieCachedDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}