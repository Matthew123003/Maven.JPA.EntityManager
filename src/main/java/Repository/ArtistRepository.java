package Repository;

import entities.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ArtistRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Artist artist){
        entityManager.persist(artist);
    }

    @Transactional
    public Artist update(Artist artist) {
        return entityManager.merge(artist);
    }

    @Transactional
    public void delete(Integer artistId) {
        Artist artist = entityManager.find(Artist.class, artistId);
        entityManager.remove(artist);
    }

    public List<Artist> findAll() {
        String jpql = "SELECT * FROM Contact Artist";
        TypedQuery<Artist> query = entityManager.createQuery(jpql, Artist.class);

        return query.getResultList();
    }

    public Artist findById(Integer id) {
        return entityManager.find(Artist.class, id);
    }
}
