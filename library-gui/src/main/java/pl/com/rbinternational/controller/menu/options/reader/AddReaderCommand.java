package pl.com.rbinternational.controller.menu.options.reader;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@MenuOption(code = "2", description = "Add reader", parent = "READER")
@RequiredArgsConstructor
public class AddReaderCommand implements Command {

    private final ReaderMenu readerMenu;

    @Override
    public void execute() {
        readerMenu.addReaderMenu();
    }
}
