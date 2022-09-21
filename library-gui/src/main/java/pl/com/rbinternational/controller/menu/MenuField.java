package pl.com.rbinternational.controller.menu;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@RequiredArgsConstructor
@Component
public class MenuField {

    private boolean exitReader;

    private Long loggedReaderId;

    private String currentMenu = "ReaderMenu";
}
