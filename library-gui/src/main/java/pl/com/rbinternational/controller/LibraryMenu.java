package pl.com.rbinternational.controller;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.com.rbinternational.controller.menu.Menu;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.MenuField;
import pl.com.rbinternational.controller.menu.options.CloseCommand;
import pl.com.rbinternational.controller.menu.options.Command;
import pl.com.rbinternational.controller.menu.options.DefaultCommand;
import pl.com.rbinternational.controller.menu.options.author.*;
import pl.com.rbinternational.controller.menu.options.book.*;
import pl.com.rbinternational.controller.menu.options.reader.ReaderMenu;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Component
@Data
@RequiredArgsConstructor
public class LibraryMenu extends Menu implements CommandLineRunner {

    private static final String READER_STRING = "READER";
    private static final String BOOK_STRING = "BOOK";
    private static final String AUTHOR_STRING = "AUTHOR";
    private static final String READER_MENU_STRING_STRING = "ReaderMenu";
    private static final String BOOK_MENU_STRING = "BookMenu";
    private static final String AUTHOR_MENU_STRING = "AuthorMenu";
    private static final String NO_MENU_SELECTED = "Nie wybrano żadnego Menu";
    private static final String NOT_FOUND_ANNOTATION = "Nie znaleziono żadnych adnotacji";

    private final Map<String, Command> readerCommands = new HashMap<>();
    private final Map<String, Command> bookCommands = new HashMap<>();
    private final Map<String, Command> authorCommands = new HashMap<>();
    private final DefaultCommand defaultCommand = new DefaultCommand();
    private final CloseCommand closeCommand = new CloseCommand();

    @Autowired
    private ApplicationContext context;

    @Autowired
    private BookMenu bookMenu;

    @Autowired
    private ReaderMenu readerMenu;

    @Autowired
    private AuthorMenu authorMenu;

    @Autowired
    private MenuField menuField;

    @Override
    public void run(String... args) {
        showMenu();
    }

    public void showMenu() {
        try {
            switch (menuField.getCurrentMenu()) {
                case READER_MENU_STRING_STRING: {
                    showMenuReader();
                    break;
                }
                case BOOK_MENU_STRING: {
                    showMenuBook();
                    break;
                }
                case AUTHOR_MENU_STRING: {
                    showMenuAuthor();
                    break;
                }
                default:
                    System.out.println(NO_MENU_SELECTED);
                    break;
            }
        } catch (Exception e) {
            Menu.incorrectFormat();
            showMenu();
        }
    }

    private void menu(Map<String, Command> hashMap) {
        String optionCode = inputNextLine();
        Command command = hashMap.get(optionCode);
        if (command != null) {
            command.execute();
            showMenu();
        } else {
            defaultCommand.execute();
            showMenu();
        }
    }

    private void showMenuReader() {
        readerMenu.showStartMenu();
        menu(readerCommands);
    }

    private void showMenuBook() {
        bookMenu.showStartMenu();
        menu(bookCommands);
    }

    private void showMenuAuthor() {
        authorMenu.showStartMenu();
        menu(authorCommands);
    }

    private void checkAnnotation(Command command) {
        if (command.getClass().isAnnotationPresent(MenuOption.class)) {
            MenuOption annotation = command.getClass().getDeclaredAnnotation(MenuOption.class);
            String code = annotation.code();
            String parent = annotation.parent();
            switch (parent) {
                case READER_STRING:
                    readerCommands.put(code, command);
                    break;
                case BOOK_STRING:
                    bookCommands.put(code, command);
                    break;
                case AUTHOR_STRING:
                    authorCommands.put(code, command);
                    break;
                default:
                    System.out.println(NOT_FOUND_ANNOTATION);
            }
        }
    }

    @PostConstruct
    public void init() {
        Map<String, Command> commandBeans = context.getBeansOfType(Command.class);
        commandBeans.forEach((k, v) -> checkAnnotation(v));
    }
}
