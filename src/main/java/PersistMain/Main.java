package PersistMain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ArtistRepository repoArtist;
    @Autowired
    private SongsRepository repoSongs;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createSong();

    }

    private void createSong() {
        Songs newSong = new Songs();

        newSong.setTitle("Weight Of Love");
        newSong.setGenre("Alt");
        newSong.setYear(2018);
        newSong.setArtist("Black Keys");

        repoSongs.save(newSong);
    }
}

