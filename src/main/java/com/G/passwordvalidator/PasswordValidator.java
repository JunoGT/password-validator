package com.G.passwordvalidator;

public interface PasswordValidator {
    /**
     * main validation method
     *
     * @param potentialPassword the password to validate
     */
    boolean validate(String potentialPassword);

    /**
     * Describes the validation criteria of this PasswordValidator.
     * 
     * @return A string description of the validation criteria.
     */
    // String describe();
}
