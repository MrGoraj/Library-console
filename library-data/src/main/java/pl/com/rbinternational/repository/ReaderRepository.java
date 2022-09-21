package pl.com.rbinternational.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.rbinternational.model.Reader;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {
}
