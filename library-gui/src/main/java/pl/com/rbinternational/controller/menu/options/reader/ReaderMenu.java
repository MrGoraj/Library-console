package pl.com.rbinternational.controller.menu.options.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.rbinternational.controller.menu.Menu;
import pl.com.rbinternational.service.ReaderService;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReaderMenu extends Menu {

    @Autowired
    private ReaderService readerService;

    public void showStartMenu() {
        System.out.println("Wybierz co chcesz zrobić:\n" +
                "1. Wybierz konto\n" +
                "2. Dodaj konto\n" +
                "3. Usuń konto\n" +
                "4. Lista wszystkich użytkowników\n" +
                "5. Wyłącz program");
    }

    public Long chooseReaderMenu() {
        System.out.println("Wybierz id swojego konta:");
        Long loggedReaderId = inputId();
        Optional<?> loggedReader = readerService.findReaderById(loggedReaderId);
        if (loggedReader.isEmpty()) {
            System.out.println("Nie ma użytkownika o takim id");
        }
        System.out.println("Wybrane konto: " + loggedReader);
        return loggedReaderId;
    }

    public void addReaderMenu() {
        System.out.println("Podaj dane nowego konta");
        addReader();
    }

    public void deleteReaderMenu() {
        System.out.println("Podaj ID konta do usunięcia");
        System.out.println(readerService.findAllReaders().toString());
        readerService.deleteReader(inputId());
    }

    public void showAllReaders() {
        System.out.println("Użytkownicy zapisani w bibliotece");
        System.out.println(readerService.findAllReaders().toString());
    }

    private void addReader() {
        System.out.println("Podaj imię");
        String firstName = inputString();
        System.out.println("Podaj nazwisko");
        String lastName = inputString();
        System.out.println("Jesteś rodzicem, czy dzieckiem? \n" +
                "1. Rodzic \n" +
                "2. Dziecko");
        int option = inputInt();
        switch (option) {
            case 1:
                System.out.println("Proszę podać dodatkowe dane kontaktowe:");
                System.out.println("Adres:");
                String address = inputString();
                System.out.println("Numer telefonu:");
                String phoneNumber = inputString();
                readerService.addParent(firstName, lastName, address, phoneNumber);
                break;
            case 2:
                System.out.println("Podaj ID konta swojego rodzica:");
                System.out.println(readerService.findAllParents().toString());
                Long parentId = inputId();
                if (readerService.findParentById(parentId).isEmpty()) {
                    System.out.println("Nie znaleziono rodzica o takim ID!");
                }
                readerService.addChild(firstName, lastName, parentId);
                break;
            default:
                System.out.println("Proszę wybrać jedną z opcji!");
                System.exit(0);
        }
    }
}