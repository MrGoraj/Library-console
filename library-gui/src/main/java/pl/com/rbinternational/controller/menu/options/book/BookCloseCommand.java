package pl.com.rbinternational.controller.menu.options.book;

import pl.com.rbinternational.controller.menu.Menu;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@MenuOption(code = "9", description = "Close menu", parent = "BOOK")
public class BookCloseCommand implements Command {

    @Override
    public void execute() {
        Menu.closeMenu();
    }
}
