package pl.com.rbinternational.controller.menu.options.reader;

import lombok.RequiredArgsConstructor;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.options.Command;

@MenuOption(code = "4", description = "Show all readers", parent = "READER")
@RequiredArgsConstructor
public class ShowAllReadersCommand implements Command {

    private final ReaderMenu readerMenu;

    @Override
    public void execute() {
        readerMenu.showAllReaders();
    }
}