package pl.com.rbinternational.controller.menu.options.book;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "7", description = "Show all books", parent = "BOOK")
public class ShowAllBooksCommand implements Command {

    private final BookMenu bookMenu;

    @Override
    public void execute() {
        bookMenu.showAllBooksMenu();
    }
}
