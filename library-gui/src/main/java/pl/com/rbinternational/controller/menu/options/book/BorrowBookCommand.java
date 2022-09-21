package pl.com.rbinternational.controller.menu.options.book;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import pl.com.rbinternational.controller.menu.MenuField;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@RequiredArgsConstructor
@MenuOption(code = "5", description = "Borrow book", parent = "BOOK")
public class BorrowBookCommand implements Command {

    private final BookMenu bookMenu;
    @Autowired
    private final MenuField menuField;

    @Override
    public void execute() {
        bookMenu.borrowBookMenu(menuField.getLoggedReaderId());
    }
}
