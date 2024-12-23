package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.*;
import mk.ukim.finki.wp.lab.model.ennumerations.Role;
import mk.ukim.finki.wp.lab.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;
    public static List<User> users = null;

    private final PasswordEncoder passwordEncoder;

    public DataHolder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static void saveSong(Song song) {
        songs.add(song);
    }

    public static void deleteSong(Song song) {
        songs.removeIf(s -> s.getTrackId().equals(song.getTrackId()));
    }

    @PostConstruct
    public void init() {
        artists = new ArrayList<>();
        artists.add(new Artist("Taylor", "Swift", "American singer-songwriter known for her biographical songwriting, artistic reinventions, and cultural impact, Swift is a leading figure in popular music and the subject of widespread public interest."));
        artists.add(new Artist("Adele", "Adkins", "English singer-songwriter whose powerful vocals and heartfelt songs have won multiple awards."));
        artists.add(new Artist("Bruno", "Mars", "American singer, songwriter, record producer, and performer known for his energetic stage presence."));
        artists.add(new Artist("Ed", "Sheeran", "English singer-songwriter known for his acoustic ballads and collaborations with various artists."));
        artists.add(new Artist("Lady", "Gaga", "American singer, songwriter, and actress known for her flamboyant costumes and powerful vocals."));

        songs = new ArrayList<>();
        songs.add(new Song("1", "Love Story", "Country pop", 2008, List.of(artists.get(0)), new Album(1L, "Fearless", "Country pop", "2008", new ArrayList<>())));
        songs.add(new Song("2", "Someone Like You", "Pop", 2011, List.of(artists.get(1)), new Album(2L, "21", "Pop", "2011", new ArrayList<>())));
        songs.add(new Song("3", "Just the Way You Are", "Reggae pop", 2010, List.of(artists.get(2)), new Album(3L, "Doo-Wops & Hooligans", "Reggae pop", "2010", new ArrayList<>())));
        songs.add(new Song("4", "Shape of You", "Pop", 2017, List.of(artists.get(3)), new Album(4L, "Divide", "Pop", "2017", new ArrayList<>())));
        songs.add(new Song("5", "Bad Romance", "Electro pop", 2009, List.of(artists.get(4)), new Album(5L, "The Fame Monster", "Electro pop", "2009", new ArrayList<>())));

        users = new ArrayList<>();
        users.add(new User("antoaneta.jordanova", passwordEncoder.encode("aj"), "Antoaneta", "Jordanova", Role.ROLE_USER));
        users.add(new User("admin", passwordEncoder.encode("admin"), "admin", "admin", Role.ROLE_ADMIN));
    }
}
