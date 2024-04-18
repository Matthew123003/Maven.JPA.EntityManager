package services;

import entities.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;


public class ArtistService{

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
            throw e;
        }
    }
    @Transactional
    public boolean deleteArtist(Integer id){
        // Begin a transaction
        entityManager.getTransaction().begin();
        try {
            // Find the Songs entity by its ID
            Artist artist = entityManager.find(Artist.class, id);

            // If the entity exists, remove it
            if (artist != null) {
                entityManager.remove(artist);
                // Commit the transaction
                entityManager.getTransaction().commit();
                return true;
            }else{
                // Entity not found
                // Rollback the transaction if necessary
                entityManager.getTransaction().rollback();
                return false; // Return false to indicate entity not found
            }


        } catch (Exception e) {
            // Rollback the transaction in case of an error
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
    @Transactional
    public Artist updateArtist(Artist artist){
        // Begin a transaction
        entityManager.getTransaction().begin();
        try {
            // Merge the updated entity using EntityManager
            Artist updatedArtist = entityManager.merge(artist);

            // Commit the transaction
            entityManager.getTransaction().commit();

            // Return the updated entity
            return updatedArtist;
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    public List<Artist> findAll(){
        try {
            return entityManager.createQuery("SELECT * FROM artist", Artist.class).getResultList();
        }catch(PersistenceException e){
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public Artist findById(Integer id) {
        try{
            return entityManager.find(Artist.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
