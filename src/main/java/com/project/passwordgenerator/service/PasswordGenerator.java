package com.project.passwordgenerator.service;

import com.project.passwordgenerator.model.PasswordCriteria;
import com.project.passwordgenerator.model.StrengthStatus;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {
    private final PasswordCriteria criteria;

    private final static String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private final static String NUMBERS = "0123456789";
    private final static String SYMBOLS = "!@#$%^&*()_+-=[]{}|;:,.<>?";
    private final SecureRandom secureRandom = new SecureRandom();

    public PasswordGenerator(PasswordCriteria criteria) {
        this.criteria = criteria;
    }

    private char getRandomCharacter(String characters) {
        int randomIndex = secureRandom.nextInt(characters.length());

        return characters.charAt(randomIndex);
    }

    public String generatePassword() {
        int length = criteria.getLength();

        StringBuilder characterPool = new StringBuilder();
        List<Character> passwordCharacters = new ArrayList<>();

        /*
         * Step 1:
         * Build the character pool based on the user's criteria.
         */

        if (criteria.isUpperCaseRequired()) {
            characterPool.append(UPPER_CASE);
        }

        if (criteria.isLowerCaseRequired()) {
            characterPool.append(LOWER_CASE);
        }

        if (criteria.isNumbersRequired()) {
            characterPool.append(NUMBERS);
        }

        if (criteria.isSymbolsRequired()) {
            characterPool.append(SYMBOLS);
        }

        /*
         * Step 2:
         * Add at least one character from every
         * category that the user requested.
         */

        if (criteria.isUpperCaseRequired()) {
            passwordCharacters.add(getRandomCharacter(UPPER_CASE));
        }

        if (criteria.isLowerCaseRequired()) {
            passwordCharacters.add(getRandomCharacter(LOWER_CASE));
        }

        if (criteria.isNumbersRequired()) {
            passwordCharacters.add(getRandomCharacter(NUMBERS));
        }

        if (criteria.isSymbolsRequired()) {
            passwordCharacters.add(getRandomCharacter(SYMBOLS));
        }

        /*
         * Step 3:
         * Fill the remaining positions randomly
         * from the combined character pool.
         */

        while (passwordCharacters.size() < length) {
            passwordCharacters.add(getRandomCharacter(characterPool.toString()));
        }

        /*
         * Step 4:
         * Shuffle the characters.
         *
         * This prevents the required characters from
         * always appearing at the beginning.
         */

        Collections.shuffle(passwordCharacters, secureRandom);

        /*
         * Step 5:
         * Convert the character list into a String.
         */

        StringBuilder password = new StringBuilder();

        for (Character character : passwordCharacters) {
            password.append(character);
        }

        return password.toString();
    }

    public static StrengthStatus checkPasswordStrength(String password) {
        int points = 0;

        if (password.length() >= 8) {
            points++;
        }

        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isNumberExists = false;
        boolean isSymbolsFound = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                isUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                isLowerCase = true;
            } else if (Character.isDigit(ch)) {
                isNumberExists = true;
            } else {
                isSymbolsFound = true;
            }
        }

        // Checking for Upper Case Letters
        if (isUpperCase) {
            points++;
        }

        // Checking for Lower Case Letters
        if (isLowerCase) {
            points++;
        }

        // Checking for Number Case Letters
        if (isNumberExists) {
            points++;
        }

        // Checking for Symbols Case Letters
        if (isSymbolsFound) {
            points++;
        }

        if (points <= 2) {
            return StrengthStatus.WEAK;
        } else if (points < 4) {
            return StrengthStatus.MEDIUM;
        } else if (points < 5) {
            return StrengthStatus.STRONG;
        } else {
            return StrengthStatus.VERY_STRONG;
        }
    }
}
