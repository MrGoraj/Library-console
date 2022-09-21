package pl.com.rbinternational.controller.menu.options.author;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.rbinternational.controller.menu.Menu;
import pl.com.rbinternational.service.AuthorService;

@Component
@RequiredArgsConstructor
public class AuthorMenu extends Menu {

    @Autowired
    private final AuthorService authorService;

    public void showStartMenu() {
        System.out.println("Wybierz co chcesz zrobić:\n" +
                "1. Dodaj autora\n" +
                "2. Usuń autora\n" +
                "3. Wyświetl informacje o autorze\n" +
                "4. Wyświetl wszystkich autorów\n" +
                "5. Wyświetl menu książek\n" +
                "6. Wyłącz program");
    }

    public void addAuthorMenu() {
        System.out.println("Podaj imię autora");
        String firstName = inputString();
        System.out.println("Podaj nazwisko");
        String lastName = inputString();
        authorService.addAuthor(firstName, lastName);
    }

    public void deleteAuthorMenu() {
        System.out.println("Podaj Id autora do usunięcia:");
        Long authorId = inputId();
        authorService.deleteAuthor(authorId);
    }

    public void showDetailAuthorInfoMenu() {
        System.out.println("Podaj ID autora, którego chcesz zobaczyć:");
        Long authorId = inputId();
        System.out.println("Dane autora:" + authorService.findAuthorById(authorId));
    }

    public void showAllAuthorsMenu() {
        System.out.println(authorService.findAll().toString());
    }
}
