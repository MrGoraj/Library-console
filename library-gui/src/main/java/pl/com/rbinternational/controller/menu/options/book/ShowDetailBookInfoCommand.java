package pl.com.rbinternational.controller.menu.options.book;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "4", description = "Show info about book", parent = "BOOK")
public class ShowDetailBookInfoCommand implements Command {

    private final BookMenu bookMenu;

    @Override
    public void execute() {
        bookMenu.showDetailBookInfoMenu();
    }
}
