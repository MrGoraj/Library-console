package pl.com.rbinternational.controller.menu.options.book;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "2", description = "Delete book", parent = "BOOK")
public class DeleteBookCommand implements Command {

    private final BookMenu bookMenu;

    @Override
    public void execute() {
        bookMenu.deleteBookMenu();
    }
}
