package pl.com.rbinternational.controller.menu.options.book;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "3", description = "Edit book", parent = "BOOK")
public class EditBookCommand implements Command {

    private final BookMenu bookMenu;

    @Override
    public void execute() {
        bookMenu.editBookMenu();
    }
}
