package PersistMain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ArtistRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        createArtist();

    }

    private void createArtist() {
        Artist newArtist = new Artist();

        newArtist.setName("Black Keys");
        newArtist.setNum_Of_Members(2);

        repo.save(newArtist);
    }
}

