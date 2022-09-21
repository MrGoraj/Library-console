package pl.com.rbinternational.controller.menu.options.author;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "3", description = "Show info about author", parent = "AUTHOR")
public class ShowDetailAuthorInfoCommand implements Command {

    private final AuthorMenu authorMenu;

    @Override
    public void execute() {
        authorMenu.showDetailAuthorInfoMenu();
    }
}
