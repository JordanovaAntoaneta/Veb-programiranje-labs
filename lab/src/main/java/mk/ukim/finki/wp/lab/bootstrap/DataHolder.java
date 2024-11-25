package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = null;
    public static List<Song> songs = null;

    @PostConstruct
    public void init() {
        artists = new ArrayList<>();
        artists.add(new Artist("Taylor", "Swift", "American singer-songwriter known for her biographical songwriting, artistic reinventions, and cultural impact, Swift is a leading figure in popular music and the subject of widespread public interest."));
        artists.add(new Artist("Adele", "Adkins", "English singer-songwriter whose powerful vocals and heartfelt songs have won multiple awards."));
        artists.add(new Artist("Bruno", "Mars", "American singer, songwriter, record producer, and performer known for his energetic stage presence."));
        artists.add(new Artist("Ed", "Sheeran", "English singer-songwriter known for his acoustic ballads and collaborations with various artists."));
        artists.add(new Artist("Lady", "Gaga", "American singer, songwriter, and actress known for her flamboyant costumes and powerful vocals."));

        songs = new ArrayList<>();
        songs.add(new Song("1", "Love Story", "Country", 2008, List.of(artists.get(0))));
        songs.add(new Song("2", "Someone Like You", "Pop", 2011, List.of(artists.get(1))));
        songs.add(new Song("3", "Just the Way You Are", "Pop", 2010, List.of(artists.get(2))));
        songs.add(new Song("4", "Shape of You", "Pop", 2017, List.of(artists.get(3))));
        songs.add(new Song("5", "Bad Romance", "Pop", 2009, List.of(artists.get(4))));
    }
}
