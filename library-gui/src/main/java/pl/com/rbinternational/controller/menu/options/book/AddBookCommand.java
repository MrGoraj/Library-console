package pl.com.rbinternational.controller.menu.options.book;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "1", description = "Add book", parent = "BOOK")
public class AddBookCommand implements Command {

    private final BookMenu bookMenu;

    @Override
    public void execute() {
        bookMenu.addBookMenu();
    }
}
