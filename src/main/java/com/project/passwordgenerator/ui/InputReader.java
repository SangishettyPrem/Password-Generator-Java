package com.project.passwordgenerator.ui;

import java.util.Scanner;

public class InputReader {
    private final Scanner scanner = new Scanner(System.in);

    public void close() {
        scanner.close();
    }

    public int readInt(String message) {
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid number.");
            }
        }
    }

    public boolean readYesOrNo(String message) {
        while (true) {
            System.out.print(message + " (Y/N): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                return true;
            }
            if (input.equals("N")) {
                return false;
            }
            System.out.println("Invalid choice. Please enter Y or N.");
        }
    }

    public String readString(String message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }
}
