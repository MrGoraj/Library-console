package pl.com.rbinternational.library.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import pl.com.rbinternational.library.service.CalculatorService;
import pl.com.rbinternational.library.service.TerminalService;

@Controller
public class CalculatorController {

    private final TerminalService terminal;
    private final CalculatorService calculator;

    public CalculatorController(TerminalService terminal, CalculatorService calculator) {
        this.terminal = terminal;
        this.calculator = calculator;
    }


    /**
     * Calculator starts
     */
    public void start() {
        try {
            int a = terminal.inputA();
            int b = terminal.inputB();
            if (a > 0 && b > 0) {
                int result = calculator.multiplication(a, b);
                System.out.println("Wynik mnożenia to: " + result);
            }
            else {
                System.out.println("Mnożyć można wyłącznie liczby dodatnie całkowite!");
            }
        } catch (Exception e) {
            System.out.println("Mnożyć można wyłącznie liczby dodatnie całkowite!");
        }
    }
}
