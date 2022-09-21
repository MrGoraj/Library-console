package pl.com.rbinternational.controller.menu.options.author;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "2", description = "Delete author", parent = "AUTHOR")
public class DeleteAuthorCommand implements Command {

    private final AuthorMenu authorMenu;

    @Override
    public void execute() {
        authorMenu.deleteAuthorMenu();
    }
}
