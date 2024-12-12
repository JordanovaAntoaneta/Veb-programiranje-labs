package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class SongRepository implements JpaRepository<Song, Long> {

    @Override
    public <S extends Song> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Song> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    public List<Song> findAll(){
        return DataHolder.songs;
    }

    @Override
    public List<Song> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

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

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Song> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Song> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Song> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Song> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Song getOne(Long aLong) {
        return null;
    }

    @Override
    public Song getById(Long aLong) {
        return null;
    }

    @Override
    public Song getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Song> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Song> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Song> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Song> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Song> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Song> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Song, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Song> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return null;
    }
}
