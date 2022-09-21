package pl.com.rbinternational.controller.menu.options.reader;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import pl.com.rbinternational.controller.menu.MenuOption;
import pl.com.rbinternational.controller.menu.MenuField;
import pl.com.rbinternational.controller.menu.options.Command;

@MenuOption(code = "1", description = "Choose reader", parent = "READER")
@RequiredArgsConstructor
public class ChooseReaderCommand implements Command {

    private final ReaderMenu readerMenu;

    @Autowired
    private MenuField menuField;

    @Override
    public void execute() {
        menuField.setLoggedReaderId(readerMenu.chooseReaderMenu());
        menuField.setCurrentMenu("BookMenu");
    }
}