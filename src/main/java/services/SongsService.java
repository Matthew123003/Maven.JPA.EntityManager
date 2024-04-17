package services;

import entities.Songs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class SongsService {

    @PersistenceContext
    private EntityManager entityManager;

    public void createSong(Songs song) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(song);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}
