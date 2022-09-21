package pl.com.rbinternational.controller.menu;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);

    public static void closeMenu() {
        System.out.println("Wyłącznie programu");
        System.exit(0);
    }

    public static void wrongOption() {
        System.out.println("Wybrano nieprawidłową opcję");
    }

    public static void incorrectFormat() {
        System.out.println("Proszę wykonywać instrukcje programu podając wymagane przez niego formaty!");
    }

    protected Long inputId() {
        System.out.println("Podaj ID");
        return scanner.nextLong();
    }

    protected int inputInt() {
        System.out.println("Podaj liczbę");
        return scanner.nextInt();
    }

    protected String inputString() {
        return scanner.next();
    }

    protected String inputNextLine() {
        return scanner.nextLine();
    }
}
