package pl.com.rbinternational.library.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    /**
     *
     * @param a The first user-specified number to be multiplied
     * @param b The second user-specified number to be multiplied
     * @return The result of the multiplication
     */
    public int multiplication(int a, int b) {
        return a * b;
    }
}
