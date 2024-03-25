package com.example.tmdb.data.repository.movie.Artist

import com.example.tmdb.data.artist.Artist
import com.example.tmdb.roomDB.ArtistDAO

class ArtistLocalDataSourceImpl(private val artistDAO: ArtistDAO):ArtistLocalDataSource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDAO.getArtist()
    }

    override suspend fun saveArtistToDB(artist: List<Artist>) {
        artistDAO.updateArtist(artist)
    }

    override suspend fun clearAll() {
        artistDAO.deleteAllArtist()
    }
}