package pl.com.rbinternational.controller.menu.options.book;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuField;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;
import pl.com.rbinternational.controller.menu.options.author.AuthorMenu;

@RequiredArgsConstructor
@MenuOption(code = "8", description = "Show author options", parent = "BOOK")
public class ShowAuthorMenuCommand implements Command {

    private final AuthorMenu authorMenu;

    private final MenuField menuField;

    @Override
    public void execute() {
        authorMenu.showStartMenu();
        menuField.setCurrentMenu("AuthorMenu");
    }
}
