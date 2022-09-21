package pl.com.rbinternational.controller.menu.options.author;

import pl.com.rbinternational.controller.menu.Menu;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@MenuOption(code = "6", description = "Close menu", parent = "AUTHOR")
public class AuthorCloseCommand implements Command {

    @Override
    public void execute() {
        Menu.closeMenu();
    }
}
