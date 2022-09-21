package pl.com.rbinternational.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.rbinternational.model.Parent;

@Repository
public interface ParentRepository extends CrudRepository<Parent, Long> {
}
