package services;

import entities.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


public class ArtistService implements Services{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
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
        }finally {
            entityManager.close();
        }
    }

    public boolean deleteArtist(){
        return true;
    }

    public Artist updateArtist(){
        return null;
    }

    public List findAll(){
        return entityManager.createQuery("SELECT * FROM artist").getResultList();
    }

    @Override
    public Integer findById() {
        return null;
    }
}
