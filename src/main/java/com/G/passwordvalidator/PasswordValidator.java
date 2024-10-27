package com.G.passwordvalidator;

/**
 * Interface for password validation.
 */
public interface PasswordValidator {
    /**
     * Checks if a password meets the validation criteria.
     *
     * @param password The password string to validate
     * @return true if the password is valid, false otherwise
     */
    boolean isValid(String password);
}
