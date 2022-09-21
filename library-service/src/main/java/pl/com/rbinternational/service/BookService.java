package pl.com.rbinternational.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.rbinternational.model.Book;
import pl.com.rbinternational.repository.AuthorRepository;
import pl.com.rbinternational.repository.BookRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    /**
     * The method triggers messages asking for data, on the basis of which it creates a Book object, adding it to the database
     */
    public void addBook(Long authorId, String title, String isbn, int amount) {
        Book book = new Book(authorRepository.findById(authorId).get(), title, isbn, amount);
        if (!bookRepository.existsByIsbn(book.getIsbn())) {
            bookRepository.save(book);
        }
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    /**
     * It allows you to change the number of books in the library's warehouse
     */
    public void editBookAmount(Long bookId, int amount) {
        Optional<Book> book = bookRepository.findById(bookId);
//        book.ifPresent(book1 -> book1.setAmount(amount));
        if (book.isPresent()) {
            book.get().setAmount(amount);
            bookRepository.save(book.orElse(null));
        }
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void findAllBooks() {
        System.out.println(bookRepository.findAll());
    }
}