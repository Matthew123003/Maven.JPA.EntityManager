package services;

import entities.Artist;
import entities.Songs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public class ArtistService implements Services{

    @PersistenceContext
    private EntityManager entityManager;

    public void createArtist(Artist artist) {
        // Begin a transaction
        entityManager.getTransaction().begin();
        try {
            // Persist the Songs entity
            entityManager.persist(artist);
            // Commit the transaction
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            entityManager.getTransaction().rollback();
            // Optionally, handle the exception
            throw e;
        }
    }


    @Override
    public Integer findById() {
        return null;
    }
}
