package pl.com.rbinternational.library.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class TerminalService {

    private final Scanner scanner = new Scanner(System.in);

    /**
     *
     * @return The first user-specified number to be multiplied is taken into account
     */
    public int inputA() {
        System.out.println("Podaj pierwszą liczbę: ");
        return scanner.nextInt();
    }

    /**
     *
     * @return The second user-specified number to be multiplied is taken into account
     */
    public int inputB() {
        System.out.println("Podaj drugą liczbę: ");
        return scanner.nextInt();
    }
}
