package pl.com.rbinternational.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.rbinternational.model.Child;

@Repository
public interface ChildRepository extends CrudRepository<Child, Long> {
}
