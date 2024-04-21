package PersistMain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.util.List;


@SpringBootApplication
public class PersistMain{
    private static final Logger log = LoggerFactory.getLogger(PersistMain.class);

    public static void main(String[] args) {
        SpringApplication.run(PersistMain.class, args);
    }

    @Bean
    CommandLineRunner runner(ArtistRepo repo) {
        return args -> {

            List<Artist> allArtists = (List<Artist>) repo.findAll();

            for (Artist artist : allArtists) {
                System.out.println(artist.getName());
            }

        };
    }
}
