package Main;


import entities.Artist;
import entities.Songs;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
            Songs song = new Songs("Weight of Love", "Alt", 2014, "Black Keys");
            Artist artist = new Artist("Black Keys", 2);

    }
}

