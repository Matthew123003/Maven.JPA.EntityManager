package services;

import entities.Songs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


public class SongsService implements Services{

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
            // Optionally, handle the exception (e.g., log it or rethrow it)
            throw e;
        }finally{
            entityManager.close();
        }
    }

    public boolean deleteSong(Songs id){
        return true;
    }

    public Songs updateSong(){
        return null;
    }

    public List findAll(){
        return entityManager.createQuery("SELECT * FROM songs").getResultList();
    }

    @Override
    public Integer findById() {
        return null;
    }
}
