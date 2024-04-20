package services;

import entities.Artist;
import entities.Songs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
@SpringBootApplication
public class Main {
    public static final String dbUrl = "jdbc:mysql://localhost:3306/MUSIC";
    public static final String username = "matt";
    public static final String password = "zipcode0";
    static Logger demoLog = Logger.getLogger("JDBC");


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        demoLog.log(Level.INFO, "Matt's MySQL Persistence");
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        // Instantiate the service classes
        SongsService songsService = new SongsService();
        ArtistService artistService = new ArtistService();

        // Create new entities to test
        Songs newSong = new Songs("Song Title", "Genre", 2024, "Artist Name");
        Artist newArtist = new Artist("Artist Name", 8);

        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connection Established to MYSQL Database");

            // Test the create method
            songsService.createSong(newSong);
            artistService.createArtist(newArtist);

            // Test the findById method
            Songs foundSong = songsService.findById(newSong.getId());
            Artist foundArtist = artistService.findById(newArtist.getId());

            // Test the update method
            foundSong.setGenre("New Genre");
            songsService.updateSong(foundSong);

            // Test the delete method
            songsService.deleteSong(foundSong.getId());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.out.println("Connection Failed! Check output console");

        } finally {
            try {
                if (conn != null)
                    conn.close();
                System.out.println("Connection closed !!");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}

