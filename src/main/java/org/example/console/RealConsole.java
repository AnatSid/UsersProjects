package org.example.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RealConsole implements Console {
    private final Scanner scanner;

    @Autowired
    public RealConsole(Scanner scanner) {
        this.scanner = scanner;
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public int nextInt() {
        return scanner.nextInt();
    }

    @Override
    public void printLn(String message) {
        System.out.println(message);
    }
}
