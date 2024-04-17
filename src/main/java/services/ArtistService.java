package services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public class ArtistService {

    @PersistenceContext
    private EntityManager entityManager;


}
