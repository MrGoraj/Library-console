package pl.com.rbinternational.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.rbinternational.model.Borrow;

import java.util.Date;
import java.util.List;

@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Long> {

    Borrow findByReaderIdAndBookId(Long readerId, Long bookId);

    List<Borrow> findAllByBookIdAndReturnDate(Long bookId, Date returnDate);
}
