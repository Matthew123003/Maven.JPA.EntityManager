package services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public class ArtistService implements Services{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Integer findById() {
        return null;
    }
}
