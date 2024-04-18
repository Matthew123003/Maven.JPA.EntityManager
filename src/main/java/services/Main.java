package services;

import entities.Artist;
import entities.Songs;

public class Main {

    public static void main(String[] args) {
        // Instantiate the service classes
        SongsService songsService = new SongsService();
        ArtistService artistService = new ArtistService();

        // Create new entities to test
        Songs newSong = new Songs("Song Title", "Genre", 2024, "Artist Name");
        Artist newArtist = new Artist("Artist Name", 8);

        try {
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
    }
}
