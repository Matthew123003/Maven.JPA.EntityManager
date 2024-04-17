package services;

import entities.Songs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class SongsService implements Services{

    @PersistenceContext
    private EntityManager entityManager;

    public void createSong(Songs song) {
        // Begin a transaction
        entityManager.getTransaction().begin();
        try {
            // Persist the Songs entity
            entityManager.persist(song);
            // Commit the transaction
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            entityManager.getTransaction().rollback();
            // Optionally, handle the exception (e.g., log it or rethrow it)
            throw e;
        }
    }

    @Override
    public Integer findById() {
        return null;
    }
}
