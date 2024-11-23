package com.G.passwordvalidator;

import java.util.regex.Pattern;

import com.cthiebaud.passwordvalidator.PasswordValidator;
import com.cthiebaud.passwordvalidator.ValidationResult;

/**
 * A custom implementation of the {@link PasswordValidator} interface.
 * <p>
 * This validator checks if a password meets the following requirements:
 * <ul>
 *   <li>Is not null</li>
 *   <li>Is not empty</li>
 *   <li>At least 8 characters in length</li>
 *   <li>Contains at least one uppercase letter</li>
 *   <li>Contains at least one lowercase letter</li>
 *   <li>Contains at least one digit</li>
 *   <li>Contains the specified sponsor keyword ("schwarz")</li>
 *   <li>Contains a Geoguesser like quiz in which the user has to find the country of a given Image</li>
 * </ul>
 * These requirements add both security and a bit of creativity to the password policy.
 */
public class PasswordLengthValidator implements PasswordValidator {

    // Regular expression patterns for password requirements
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*");
    private static final Pattern DIGITS_PATTERN = Pattern.compile(".*\\d.*");
    private static final Pattern SPONSOR_PATTERN = Pattern.compile(".*schwarz.*", Pattern.CASE_INSENSITIVE);
    private static final Pattern GEOGUESSR_PATTERN = Pattern.compile(".*sweden.*", Pattern.CASE_INSENSITIVE);

    /**
     * Validates the given password based on predefined criteria.
     *
     * @param potentialPassword the password to validate
     * @return {@code true} if the password meets all criteria; {@code false} otherwise
     */
    @Override
    public ValidationResult validate(String potentialPassword) {
        if (potentialPassword == null || potentialPassword.isEmpty()) {
            return new ValidationResult(false, "You need to enter a Password!");
        }
        if (potentialPassword.length() < 8) {
            return new ValidationResult(false, "Your Password is too short!");
        }
        if (!UPPERCASE_PATTERN.matcher(potentialPassword).matches()) {
            return new ValidationResult(false, "You don't have an Uppercase Letter!");
        }
        if (!LOWERCASE_PATTERN.matcher(potentialPassword).matches()) {
            return new ValidationResult(false, "You don't have a Lowercase Letter!");
        }
        if (!DIGITS_PATTERN.matcher(potentialPassword).matches()) {
            return new ValidationResult(false, "You don't have a Digit!");
        }
        if (!SPONSOR_PATTERN.matcher(potentialPassword).matches()) {
            return new ValidationResult(false, "You don't have our Sponsor included (It's Schwarz)!");
        }
        if (!GEOGUESSR_PATTERN.matcher(potentialPassword).matches()) {
            return new ValidationResult(false, "You forgot to include the correct Country, Which Country is this? https://imgur.com/a/R6mMpnn included! (Don't Cheat :) )");
        }
        return new ValidationResult(true, "");
    }
}
