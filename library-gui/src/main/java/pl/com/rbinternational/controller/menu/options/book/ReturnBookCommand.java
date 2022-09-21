package pl.com.rbinternational.controller.menu.options.book;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import pl.com.rbinternational.controller.menu.MenuField;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "6", description = "Return borrowed book", parent = "BOOK")
public class ReturnBookCommand implements Command {

    private final BookMenu bookMenu;
    @Autowired
    private final MenuField menuField;

    @Override
    public void execute() {
        bookMenu.returnBookMenu(menuField.getLoggedReaderId());
    }
}
