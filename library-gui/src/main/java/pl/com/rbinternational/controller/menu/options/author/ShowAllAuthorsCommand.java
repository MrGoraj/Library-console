package pl.com.rbinternational.controller.menu.options.author;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "4", description = "Show all authors", parent = "AUTHOR")
public class ShowAllAuthorsCommand implements Command {

    private final AuthorMenu authorMenu;

    @Override
    public void execute() {
        authorMenu.showAllAuthorsMenu();
    }
}
