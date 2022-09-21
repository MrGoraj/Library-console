package pl.com.rbinternational.controller.menu.options.author;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuField;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;
import pl.com.rbinternational.controller.menu.options.book.BookMenu;

@RequiredArgsConstructor
@MenuOption(code = "5", description = "Show book menu", parent = "AUTHOR")
public class ShowBookMenuCommand implements Command {

    private final BookMenu bookMenu;

    private final MenuField menuField;

    @Override
    public void execute() {
        bookMenu.showStartMenu();
        menuField.setCurrentMenu("BookMenu");
    }
}
