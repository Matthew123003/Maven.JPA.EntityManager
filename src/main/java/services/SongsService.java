package services;

import entities.Songs;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class SongsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
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
            throw e;
        }
    }
    @Transactional
    public boolean deleteSong(Integer id){
        // Begin a transaction
        entityManager.getTransaction().begin();
        try {
            // Find the Songs entity by its ID
            Songs song = entityManager.find(Songs.class, id);

            // If the entity exists, remove it
            if (song != null) {
                entityManager.remove(song);
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
    public Songs updateSong(Songs song){
        // Begin a transaction
        entityManager.getTransaction().begin();
        try {
            // Merge the updated entity using EntityManager
            Songs updatedSong = entityManager.merge(song);

            // Commit the transaction
            entityManager.getTransaction().commit();

            // Return the updated entity
            return updatedSong;
        } catch (Exception e) {
            // Rollback the transaction in case of an error
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Transactional
    public List<Songs> findAll(){
        try {
            //return entityManager.createQuery("SELECT * FROM songs", Songs.class).getResultList();
            String jpql = "SELECT * FROM Artist";
            TypedQuery<Songs> query = entityManager.createQuery(jpql, Songs.class);
            return query.getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    public Songs findById(Integer id) {
        try{
            return entityManager.find(Songs.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
