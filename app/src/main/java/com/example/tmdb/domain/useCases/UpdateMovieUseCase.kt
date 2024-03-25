package com.example.tmdb.domain.useCases

import com.example.tmdb.domain.repository.MovieRepository
import com.example.tmdb.data.movie.Movie

class UpdateMovieUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}