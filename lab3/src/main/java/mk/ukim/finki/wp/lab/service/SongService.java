package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface SongService{
    List<Song> listSongs();
    void addArtistToSong(String artistId, String trackId);
    Song findByTrackId(String trackId);

    void save(String title, String genre, String releaseYear, Long albumId);

    void edit(Long id, String title, String genre, String releaseYear, Long albumId);

    void delete(Long id);

    String details(Long id);

    void saveSong(Song song);

    void deleteSong(Long id);
}

