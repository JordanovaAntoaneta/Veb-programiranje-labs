package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.*;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;
    private final ArtistService artistService;
    private final AlbumService albumService;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, ArtistService artistService, AlbumService albumService, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.artistService = artistService;
        this.albumService = albumService;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public void addArtistToSong(String artistId, String trackId) {
        Artist artist = artistService.findById(Long.parseLong(artistId));

        Song song = songRepository.findByTrackId(trackId).orElseThrow();

        song.getPerformers().add(artist);

        songRepository.save(song);

    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId).orElse(null);
    }

    @Override
    public void save(String title, String genre, String releaseYear, Long albumId) {
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new RuntimeException("Album not found"));

        Song song = new Song();
        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(Integer.parseInt(releaseYear));

        DataHolder.saveSong(song);
    }

    @Override
    public void edit(Long id, String title, String genre, String releaseYear, Long albumId) {
        Song song = songRepository.findByTrackId(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Song not found"));

        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new RuntimeException("Album not found"));

        song.setTitle(title);
        song.setGenre(genre);
        song.setReleaseYear(Integer.parseInt(releaseYear));
        song.setAlbum(album);

        songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        Song song = songRepository.findByTrackId(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Song not found"));

        DataHolder.deleteSong(song);
    }

    @Override
    public String details(Long id){
        Song song = songRepository.findByTrackId(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Song not found"));

        return song.getTrackId();
    }
}
