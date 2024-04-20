package Repository;

import entities.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SongsRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void save(Songs song){
        entityManager.persist(song);
    }

    @Transactional
    public Songs update(Songs song) {
        return entityManager.merge(song);
    }

    @Transactional
    public void delete(Integer songId) {
        Songs song = entityManager.find(Songs.class, songId);
        entityManager.remove(song);
    }

    public List<Songs> findAll() {
        String jpql = "SELECT * FROM Contact Songs";
        TypedQuery<Songs> query = entityManager.createQuery(jpql, Songs.class);

        return query.getResultList();
    }

    public Songs findById(Integer id) {
        return entityManager.find(Songs.class, id);
    }
}
