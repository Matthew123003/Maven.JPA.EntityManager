package PersistMain;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface ArtistRepo extends CrudRepository<Artist, Integer> {
    Artist save(Artist artist);
    Optional<Artist> findById(Integer id);

    Iterable<Artist> findAll();
    void deleteById(long id);
    void delete(Artist artist);

    long count();
    Iterable<Artist> findAllById(Iterable<Integer> id);
}
