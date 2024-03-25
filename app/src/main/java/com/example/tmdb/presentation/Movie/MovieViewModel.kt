package com.example.tmdb.presentation.Movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdb.data.movie.Movie
import com.example.tmdb.domain.useCases.GetMoviesUseCase
import com.example.tmdb.domain.useCases.UpdateMovieUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMovieUseCase: UpdateMovieUseCase
):ViewModel() {

    fun getMovies():LiveData<List<Movie>?> = liveData {
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData<List<Movie>?> {
        val movieList = updateMovieUseCase.execute()
        emit(movieList)
    }
}