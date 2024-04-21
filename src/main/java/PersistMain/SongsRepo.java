package PersistMain;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface SongsRepo extends CrudRepository<Songs, Integer> {
    Songs save(Songs song);
    Optional<Songs> findById(Integer id);
    Iterable<Songs> findAll();
    void deleteById(long id);
    void delete(Songs song);
    long count();
    Iterable<Songs> findAllById(Iterable<Integer> id);
}
