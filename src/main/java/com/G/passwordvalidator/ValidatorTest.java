package com.G.passwordvalidator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link CustomPasswordValidator} implementation of the {@link PasswordValidator} interface.
 * <p>
 * Tests various scenarios for password validation, ensuring that the implementation correctly identifies
 * valid and invalid passwords according to defined criteria.
 */
public class ValidatorTest {

    /**
     * An instance of the CustomPasswordValidator to validate passwords.
     */
    private final PasswordValidator validator = new CustomPasswordValidator();

    /**
     * Tests a password that meets all the required criteria:
     * - Minimum length of 8 characters
     * - At least one uppercase letter
     * - At least one lowercase letter
     * - At least one numeric digit
     */
    @Test
    @DisplayName("Test valid password meets all criteria")
    void testValidPassword() {
        String password = "ValidPass1";
        assertTrue(validator.isValid(password), "Password should be valid");
    }

    /**
     * Tests a password that is too short, i.e., fewer than 8 characters.
     * Ensures that passwords failing the length requirement are invalid.
     */
    @Test
    @DisplayName("Test invalid password: too short")
    void testInvalidPasswordTooShort() {
        String password = "Pwd1";
        assertFalse(validator.isValid(password), "Password is too short and should be invalid");
    }

    /**
     * Tests a password that does not contain any uppercase letters.
     * Ensures that passwords missing an uppercase letter are invalid.
     */
    @Test
    @DisplayName("Test invalid password: no uppercase letter")
    void testInvalidPasswordNoUppercase() {
        String password = "password1";
        assertFalse(validator.isValid(password), "Password has no uppercase letter and should be invalid");
    }

    /**
     * Tests a password that does not contain any lowercase letters.
     * Ensures that passwords missing a lowercase letter are invalid.
     */
    @Test
    @DisplayName("Test invalid password: no lowercase letter")
    void testInvalidPasswordNoLowercase() {
        String password = "PASSWORD1";
        assertFalse(validator.isValid(password), "Password has no lowercase letter and should be invalid");
    }

    /**
     * Tests a password that does not contain any numeric digits.
     * Ensures that passwords missing a digit are invalid.
     */
    @Test
    @DisplayName("Test invalid password: no digit")
    void testInvalidPasswordNoDigit() {
        String password = "Password";
        assertFalse(validator.isValid(password), "Password has no digit and should be invalid");
    }

    /**
     * Tests a null password.
     * Ensures that the validator correctly identifies null passwords as invalid.
     */
    @Test
    @DisplayName("Test edge case: null password")
    void testNullPassword() {
        String password = null;
        assertFalse(validator.isValid(password), "Null password should be invalid");
    }

    /**
     * Tests an empty password string.
     * Ensures that the validator correctly identifies empty passwords as invalid.
     */
    @Test
    @DisplayName("Test edge case: empty password")
    void testEmptyPassword() {
        String password = "";
        assertFalse(validator.isValid(password), "Empty password should be invalid");
    }

    /**
     * Tests a password that is exactly the minimum required length of 8 characters.
     * Ensures that the validator accepts a password meeting the minimum length criterion along with other criteria.
     */
    @Test
    @DisplayName("Test minimum length boundary (8 characters)")
    void testMinimumLengthBoundary() {
        String password = "Abcdef1g";
        assertTrue(validator.isValid(password), "Password meets the minimum length and should be valid");
    }
}
