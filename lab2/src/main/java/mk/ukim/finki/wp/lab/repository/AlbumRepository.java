package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {
    private final List<Album> albums;

    public AlbumRepository() {
        albums = new ArrayList<>();
        albums.add(new Album(1L, "Fearless", "Country pop", "2008", new ArrayList<>()));
        albums.add(new Album(2L, "21", "Pop", "2011", new ArrayList<>()));
        albums.add(new Album(3L, "Doo-Wops & Hooligans", "Reggae pop", "2010", new ArrayList<>()));
        albums.add(new Album(4L, "Divide", "Pop", "2017", new ArrayList<>()));
        albums.add(new Album(5L, "The Fame Monster", "Electro pop", "2009", new ArrayList<>()));
    }

    public List<Album> findAll() {
        return albums;
    }

    public Optional<Album> findById(Long id){
         return albums.stream().filter(a -> a.getId().equals(id)).findFirst();
    }
}

