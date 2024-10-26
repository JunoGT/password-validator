package com.G;

import com.G.passwordvalidator.PasswordValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    private final PasswordValidator validator = new ValidatorTest();

    @Test
    public void testValidPassword() {
        assertTrue(validator.isValid("EpicPassword1"));
    }

    @Test
    public void testInvalidPasswordTooShort() {
        assertFalse(validator.isValid("Epic1"));
    }

    @Test
    public void testInvalidPasswordNoUppercase() {
        assertFalse(validator.isValid("epicpassword1"));
    }

    @Test
    public void testInvalidPasswordNoDigit() {
        assertFalse(validator.isValid("EpicPassword"));
    }

    @Test
    public void testInvalidPasswordNoFunWord() {
        assertFalse(validator.isValid("BoringPassword1"));
    }

    @Test
    public void testInvalidPasswordForbiddenPhrase() {
        assertFalse(validator.isValid("CoolPassword123"));
    }
}
//Bun