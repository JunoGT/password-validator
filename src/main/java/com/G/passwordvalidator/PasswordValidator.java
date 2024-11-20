package com.cthiebaud.passwordvalidator;

/**
 * The {@code PasswordValidator} interface defines a contract for validating
 * potential passwords based on specific criteria. Implementing classes must
 * provide their own validation logic and a description of the criteria used.
 * 
 * <p>
 * This interface facilitates the creation of various password validation
 * strategies, allowing users to easily integrate and manage multiple validation
 * rules in a consistent manner.
 * </p>
 * 
 * @see ValidationResult
 */
public interface PasswordValidator {
    /**
     * Validates a potential password based on specific criteria.
     * 
     * @param potentialPassword the password to validate
     * @return ValidationResult containing the validation status and an optional
     *         message describing the result of the validation
     */
    ValidationResult validate(String potentialPassword);

    /**
     * Describes the validation criteria of this PasswordValidator.
     * 
     * @return A string description of the validation criteria.
     */
    // String describe();
}
