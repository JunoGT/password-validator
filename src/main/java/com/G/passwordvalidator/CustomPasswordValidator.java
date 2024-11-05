package com.G.passwordvalidator;

/**
 * Custom implementation of PasswordValidator with specific criteria.
 */

public class CustomPasswordValidator implements PasswordValidator {
    @Override
    public boolean isValid(String password) {
        // 8 Zeichen min
        // min 1 Großbuchstaben
        // min 1 Kleinbuchstaben
        // min 1 Ziffer
        // leer ""
        // null
        // Sponsoren
        return false;//to be done
        // TEST

    }
}