package pl.com.rbinternational.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.com.rbinternational.library.controller.CalculatorController;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

    @Autowired
    private CalculatorController calculator;

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

    @Override
    public void run(String... args) {

        calculator.start();
    }
}