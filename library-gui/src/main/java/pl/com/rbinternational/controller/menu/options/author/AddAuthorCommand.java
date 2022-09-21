package pl.com.rbinternational.controller.menu.options.author;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "1", description = "Add author", parent = "AUTHOR")
public class AddAuthorCommand implements Command {
    private final AuthorMenu authorMenu;

    @Override
    public void execute() {
        authorMenu.addAuthorMenu();
    }
}
