package com.G.passwordvalidator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link PasswordLengthValidator} implementation of the {@link PasswordValidator} interface.
 * <p>
 * Tests various scenarios for password validation, ensuring that the implementation correctly identifies
 * valid and invalid passwords according to defined criteria.
 */
@TestMethodOrder(OrderAnnotation.class) // Specifies that tests will be run in the order defined by @Order
public class ValidatorTest {

    /**
     * An instance of the CustomPasswordValidator to validate passwords.
     */
    private final PasswordValidator validator = new PasswordLengthValidator();

    @Test
    @Order(0)
    @DisplayName("Test null password")
    void testNullPassword() {
        System.out.println("Test0");
        String password = null;
        assertFalse(validator.validate(password), "Password should be invalid when null");
    }

    @Test
    @Order(1)
    @DisplayName("Test valid password meets all criteria")
    void testValidPassword() {
        System.out.println("Test1");
        String password = "SchwarzVal1sweden";
        assertTrue(validator.validate(password), "Password should be valid");
    }

    @Test
    @Order(2)
    @DisplayName("Test invalid password: too short")
    void testInvalidPasswordTooShort() {
        System.out.println("Test2");
        String password = "Schw1";
        assertFalse(validator.validate(password), "Password is too short and should be invalid");
    }

    @Test
    @Order(3)
    @DisplayName("Test invalid password: no uppercase letter")
    void testInvalidPasswordNoUppercase() {
        System.out.println("Test3");
        String password = "schwarz1sweden";
        assertFalse(validator.validate(password), "Password has no uppercase letter and should be invalid");
    }

    @Test
    @Order(4)
    @DisplayName("Test invalid password: no lowercase letter")
    void testInvalidPasswordNoLowercase() {
        System.out.println("Test4");
        String password = "SCHWARZ1SWEDEN";
        assertFalse(validator.validate(password), "Password has no lowercase letter and should be invalid");
    }

    @Test
    @Order(5)
    @DisplayName("Test invalid password: no digit")
    void testInvalidPasswordNoDigit() {
        System.out.println("Test5");
        String password = "SchwarzSweden";
        assertFalse(validator.validate(password), "Password has no digit and should be invalid");
    }

    @Test
    @Order(6)
    @DisplayName("Test missing sponsor")
    void testMissingSponsor() {
        System.out.println("Test6");
        String password = "ValidPass1sweden";
        assertFalse(validator.validate(password), "Password should be invalid without sponsor");
    }

    @Test
    @Order(7)
    @DisplayName("Test missing GeoGuesser country")
    void testMissingGeoGuesserCountry() {
        System.out.println("Test7");
        String password = "SchwarzValidPass1";
        assertFalse(validator.validate(password), "Password should be invalid without GeoGuesser country");
    }
}
