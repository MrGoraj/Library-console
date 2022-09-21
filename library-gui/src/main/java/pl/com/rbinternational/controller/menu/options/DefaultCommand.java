package pl.com.rbinternational.controller.menu.options;

import pl.com.rbinternational.controller.menu.Menu;

public class DefaultCommand implements Command {

    @Override
    public void execute() {
        Menu.wrongOption();
    }
}
