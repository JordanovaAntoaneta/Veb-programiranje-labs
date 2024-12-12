package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class AlbumRepository implements JpaRepository<Album, Long> {
    private final List<Album> albums;

    public AlbumRepository() {
        albums = new ArrayList<>();
        albums.add(new Album(1L, "Fearless", "Country pop", "2008", new ArrayList<>()));
        albums.add(new Album(2L, "21", "Pop", "2011", new ArrayList<>()));
        albums.add(new Album(3L, "Doo-Wops & Hooligans", "Reggae pop", "2010", new ArrayList<>()));
        albums.add(new Album(4L, "Divide", "Pop", "2017", new ArrayList<>()));
        albums.add(new Album(5L, "The Fame Monster", "Electro pop", "2009", new ArrayList<>()));
    }

    @Override
    public <S extends Album> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Album> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    public List<Album> findAll() {
        return albums;
    }

    @Override
    public List<Album> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Album entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Album> entities) {

    }

    @Override
    public void deleteAll() {

    }

    public Optional<Album> findById(Long id){
         return albums.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Album> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Album> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Album> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Album getOne(Long aLong) {
        return null;
    }

    @Override
    public Album getById(Long aLong) {
        return null;
    }

    @Override
    public Album getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Album> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Album> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Album> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Album> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Album> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Album> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Album, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Album> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Album> findAll(Pageable pageable) {
        return null;
    }
}

