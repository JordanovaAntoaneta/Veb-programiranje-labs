package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository("defaultSongRepository")
public class SongRepository {

    public List<Song> findAll(){
        return DataHolder.songs;
    }
   public Optional<Song> findByTrackId(String trackId){
        return DataHolder.songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst();
   }
    public Artist addArtistToSong(Artist artist, Song song) {
       song.getPerformers().add(artist);

       this.save(song);

       return artist;
    }

    public Song save(Song song) {
        DataHolder.songs.removeIf(s -> Objects.equals(s.getTrackId(), song.getTrackId()));

        DataHolder.songs.add(song);

        return song;
    }

    public void delete(Song song) {
        DataHolder.songs.removeIf(s -> s.getTrackId().equals(song.getTrackId()));
    }
}
