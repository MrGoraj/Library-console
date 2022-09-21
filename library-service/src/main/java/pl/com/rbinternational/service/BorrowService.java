package pl.com.rbinternational.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.rbinternational.model.Book;
import pl.com.rbinternational.model.Borrow;
import pl.com.rbinternational.repository.BookRepository;
import pl.com.rbinternational.repository.BorrowRepository;
import pl.com.rbinternational.repository.ReaderRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class BorrowService {

    @Autowired
    private final BorrowRepository borrowRepository;

    @Autowired
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    /**
     * @param readerId ID of the reader logged in to the application
     * @param bookId   ID of the book the reader wants to borrow
     */
    public void borrowBook(Long readerId, Long bookId) {
        LocalDate currentDate = LocalDate.now();
        Borrow borrow = new Borrow(Date.valueOf(currentDate), null, readerRepository.findById(readerId).get(), bookRepository.findById(bookId).get());
        Optional<Book> book = bookRepository.findById(bookId);
        Borrow borrowed = borrowRepository.findByReaderIdAndBookId(readerId, bookId);
        Integer borrowedAmount = borrowRepository.findAllByBookIdAndReturnDate(bookId, null).size();
        if (borrowed == null && borrowedAmount < book.get().getAmount()) {
            borrowRepository.save(borrow);
        }
    }

    /**
     * @param readerId ID of the reader logged in to the application
     * @param bookId   ID of the book the reader wants to borrow
     */
    public void returnBorrowedBook(Long readerId, Long bookId) {
        LocalDate currentDate = LocalDate.now();
        Borrow borrowed = borrowRepository.findByReaderIdAndBookId(readerId, bookId);
        if (borrowed != null) {
            borrowed.setReturnDate(Date.valueOf(currentDate));
            borrowRepository.save(borrowed);
        }
    }
}