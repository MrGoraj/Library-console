package pl.com.rbinternational.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.rbinternational.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    boolean existsByIsbn(String isbn);
}
