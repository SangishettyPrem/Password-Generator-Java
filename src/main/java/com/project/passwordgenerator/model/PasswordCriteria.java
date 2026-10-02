package com.project.passwordgenerator.model;

public class PasswordCriteria {
    private final int length;
    private final boolean isUpperCaseRequired;
    private final boolean isLowerCaseRequired;
    private final boolean isNumbersRequired;
    private final boolean isSymbolsRequired;

    public PasswordCriteria(int length, boolean isUpperCaseRequired, boolean isLowerCaseRequired, boolean isNumbersRequired, boolean isSymbolsRequired) {
        this.length = length;
        this.isUpperCaseRequired = isUpperCaseRequired;
        this.isLowerCaseRequired = isLowerCaseRequired;
        this.isNumbersRequired = isNumbersRequired;
        this.isSymbolsRequired = isSymbolsRequired;
    }

    public int getLength() {
        return length;
    }

    public boolean isUpperCaseRequired() {
        return isUpperCaseRequired;
    }

    public boolean isLowerCaseRequired() {
        return isLowerCaseRequired;
    }

    public boolean isNumbersRequired() {
        return isNumbersRequired;
    }

    public boolean isSymbolsRequired() {
        return isSymbolsRequired;
    }

    @Override
    public String toString() {
        return "PasswordCriteria{" +
                "length=" + length +
                ", isUpperCaseRequired=" + isUpperCaseRequired +
                ", isLowerCaseRequired=" + isLowerCaseRequired +
                ", isNumbersRequired=" + isNumbersRequired +
                ", isSymbolsRequired=" + isSymbolsRequired +
                '}';
    }
}
