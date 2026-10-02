package com.project.passwordgenerator.ui;

import com.project.passwordgenerator.model.PasswordCriteria;
import com.project.passwordgenerator.model.StrengthStatus;
import com.project.passwordgenerator.service.PasswordGenerator;

public class ConsoleApplication {
    private final InputReader inputReader;

    public ConsoleApplication() {
        this.inputReader = new InputReader();
    }

    private boolean validatePasswordLength(int length) {
        if (length < 8) {
            System.out.println("Min Length of Password should be 8");
            return true;
        }
        return false;
    }

    public void generatePassword() {
        int length = inputReader.readInt("Password Length");
        while (validatePasswordLength(length)) {
            System.out.println("Invalid Password Length");
            length = inputReader.readInt("Password Length");
        }

        boolean includeUpperCase = inputReader.readYesOrNo("Upper Case Letters are required");
        boolean includeLowerCase = inputReader.readYesOrNo("Lower Case Letters are required");
        boolean includeNumbers = inputReader.readYesOrNo("Numbers are required");
        boolean includeSymbols = inputReader.readYesOrNo("Symbols are required");
        PasswordCriteria criteria = new PasswordCriteria(length, includeUpperCase, includeLowerCase, includeNumbers, includeSymbols);
        PasswordGenerator passwordGenerator = new PasswordGenerator(criteria);

        String password = passwordGenerator.generatePassword();
        System.out.println("Here is Your Strong Generated Password: " + password);
    }

    public void checkPasswordStrength() {
        String userPassword = inputReader.readString("Enter the Password to check the Strength of it: ");
        StrengthStatus status = PasswordGenerator.checkPasswordStrength(userPassword);
        System.out.println("Your Password Strength is " + status.toString().replaceAll("_", " "));
    }

    public void showMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("       Password Generator & Analyzer");
        System.out.println("========================================");

        System.out.println();
        System.out.println("1. Generate Password");
        System.out.println("2. Check Password Strength");
        System.out.println("3. Exit");

        System.out.println();
    }

    public void showExitApplication() {
        System.out.println("Thank you for Using Password Generator Application. Bye, Bye");
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = inputReader.readInt("Enter the Choice");
            switch (choice) {
                case 1 -> {
                    generatePassword();
                }
                case 2 -> {
                    checkPasswordStrength();
                }
                case 3 -> {
                    showExitApplication();
                    inputReader.close();
                    return;
                }
                default -> System.out.println("Invalid Choice. Please select 1-3");
            }
        }
    }

    public static void main(String[] args) {
        ConsoleApplication console = new ConsoleApplication();
        console.start();
    }
}
