package pl.com.rbinternational.controller.menu.options.book;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.rbinternational.controller.menu.Menu;
import pl.com.rbinternational.service.BookService;
import pl.com.rbinternational.service.BorrowService;

@RequiredArgsConstructor
@Component
public class BookMenu extends Menu {

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowService borrowService;

    public void showStartMenu() {
        System.out.println("Wybierz co chcesz zrobić z książką:\n" +
                "1. Dodaj książkę\n" +
                "2. Usuń książkę\n" +
                "3. Zmień ilość sztuk w asortymencie\n" +
                "4. Wyświetl informacje o książce\n" +
                "5. Wypożycz książkę\n" +
                "6. Oddaj wypożyczoną książkę\n" +
                "7. Wyświetl wszystkie książki\n" +
                "8. Wyświetl menu autorów\n" +
                "9. Wyłącz program");
    }

    public void addBookMenu() {
        System.out.println("Podaj tytuł książki");
        String title = inputString();
        System.out.println("Podaj ID autora książki");
        Long authorId = inputId();
        System.out.println("Podaj numer ISBN książki");
        String isbn = inputString();
        System.out.println("Podaj ilość sztuk w magazynie");
        int amount = inputInt();
        bookService.addBook(authorId, title, isbn, amount);
    }

    public void editBookMenu() {
        bookService.findAllBooks();
        System.out.println("Podaj id książki do edytowania");
        Long bookId = inputId();
        System.out.println("Podaj nową ilość sztuk w magazynie");
        int amount = inputInt();
        bookService.editBookAmount(bookId, amount);
        System.out.println("Pomyślnie zaktualizowano liczbę sztuk w asortymencie");
    }

    public void deleteBookMenu() {
        System.out.println("Podaj ID książki do usunięcia");
        bookService.findAllBooks();
        bookService.deleteBook(inputId());
    }

    public void showDetailBookInfoMenu() {
        System.out.println("Podaj ID książki o której chcesz wyświetlić informacje");
        System.out.println(bookService.findBookById(inputId()).toString());
    }

    public void showAllBooksMenu() {
        System.out.println("Książki dostępne w bibliotece:");
        bookService.findAllBooks();
    }

    public void borrowBookMenu(Long loggedReaderId) {
        System.out.println("Podaj ID książki, którą chcesz wypożyczyć");
        bookService.findAllBooks();
        Long bookId = inputId();
        borrowService.borrowBook(loggedReaderId, bookId);
    }

    public void returnBookMenu(Long loggedReaderId) {
        System.out.println("Podaj ID książki, którą chcesz oddać");
        Long borrowedBookId = inputId();
        borrowService.returnBorrowedBook(loggedReaderId, borrowedBookId);
    }
}