package pl.com.rbinternational.controller.menu.options.reader;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@MenuOption(code = "3", description = "Delete reader", parent = "READER")
@RequiredArgsConstructor
public class DeleteReaderCommand implements Command {

    private final ReaderMenu readerMenu;

    @Override
    public void execute() {
        readerMenu.deleteReaderMenu();
    }
}
