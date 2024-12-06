package com.G.passwordvalidator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link PasswordLengthValidator} implementation of the {@link PasswordValidator} interface.
 * <p>
 * Tests various scenarios for password validation, ensuring that the implementation correctly identifies
 * valid and invalid passwords according to defined criteria.
 */
@TestMethodOrder(OrderAnnotation.class) // Specifies that tests will be run in the order defined by @Order
class ValidatorTest {

    /**
     * An instance of the PasswordLengthValidator to validate passwords.
     */
    private PasswordLengthValidator validator;

    /**
     * Initializes the validator instance before each test.
     */
    @BeforeEach
    void init() {
        // Initialize validator with dynamic sponsor and GeoGuesser country
        validator = new PasswordLengthValidator("Schwarz", "Sweden");
    }

    /**
     * Tests that a null password is considered invalid.
     */
    @Test
    @Order(0)
    @DisplayName("Test null password")
    void testNullPassword() {
        System.out.println("Test0");
        String password = null;
        assertFalse(validator.validate(password).isValid(), "Password should be invalid when null");
    }

    /**
     * Tests various valid and invalid passwords using parameterized inputs.
     *
     * @param password the password to validate
     * @param isValid  expected validation result
     */
    @ParameterizedTest
    @Order(1)
    @DisplayName("Test valid password meets all criteria")
    @CsvSource({
            "SchwarzVal1sweden, true",
            "Schwarz2Sweden, true",
            "InvalidPass, false"
    })
    void testPasswordValidation(String password, boolean isValid) {
        System.out.println("Parameterized Test");
        assertEquals(isValid, validator.validate(password).isValid(), "Password validation failed for: " + password);
    }

    /**
     * Tests that a password that is too short is considered invalid.
     */
    @Test
    @Order(2)
    @DisplayName("Test invalid password: too short")
    void testInvalidPasswordTooShort() {
        System.out.println("Test2");
        String password = "Schw1";
        assertFalse(validator.validate(password).isValid(), "Password is too short and should be invalid");
    }

    /**
     * Tests that a password without an uppercase letter is considered invalid.
     */
    @Test
    @Order(3)
    @DisplayName("Test invalid password: no uppercase letter")
    void testInvalidPasswordNoUppercase() {
        System.out.println("Test3");
        String password = "schwarz1sweden";
        assertFalse(validator.validate(password).isValid(), "Password has no uppercase letter and should be invalid");
    }

    /**
     * Tests that a password without a lowercase letter is considered invalid.
     */
    @Test
    @Order(4)
    @DisplayName("Test invalid password: no lowercase letter")
    void testInvalidPasswordNoLowercase() {
        System.out.println("Test4");
        String password = "SCHWARZ1SWEDEN";
        assertFalse(validator.validate(password).isValid(), "Password has no lowercase letter and should be invalid");
    }

    /**
     * Tests that a password without a digit is considered invalid.
     */
    @Test
    @Order(5)
    @DisplayName("Test invalid password: no digit")
    void testInvalidPasswordNoDigit() {
        System.out.println("Test5");
        String password = "SchwarzSweden";
        assertFalse(validator.validate(password).isValid(), "Password has no digit and should be invalid");
    }

    /**
     * Tests that a password missing the sponsor keyword is considered invalid.
     */
    @Test
    @Order(6)
    @DisplayName("Test missing sponsor")
    void testMissingSponsor() {
        System.out.println("Test6");
        String password = "ValidPass1sweden";
        assertFalse(validator.validate(password).isValid(), "Password should be invalid without sponsor");
    }

    /**
     * Tests that a password missing the GeoGuesser country is considered invalid.
     */
    @Test
    @Order(7)
    @DisplayName("Test missing GeoGuesser country")
    void testMissingGeoGuesserCountry() {
        System.out.println("Test7");
        String password = "SchwarzValidPass1";
        assertFalse(validator.validate(password).isValid(), "Password should be invalid without GeoGuesser country");
    }
}
