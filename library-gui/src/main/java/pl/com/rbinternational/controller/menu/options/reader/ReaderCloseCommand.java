package pl.com.rbinternational.controller.menu.options.reader;

import pl.com.rbinternational.controller.menu.Menu;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@MenuOption(code = "5", description = "Close menu", parent = "READER")
public class ReaderCloseCommand implements Command {
    @Override
    public void execute() {
        Menu.closeMenu();
    }
}
