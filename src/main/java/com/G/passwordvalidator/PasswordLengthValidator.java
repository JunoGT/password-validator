package com.G.passwordvalidator;

import java.util.regex.Pattern;
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
    public boolean validate(String potentialPassword) {
        if (potentialPassword == null || potentialPassword.isEmpty()) {
            System.out.println("You need to enter a Password!");
            return false;
        }
        if (potentialPassword.length() < 8) {
            System.out.println("Your Password is too short!");
            return false;
        }
        if (!UPPERCASE_PATTERN.matcher(potentialPassword).matches()) {
            System.out.println("You don't have an Uppercase Letter!");
            return false;
        }
        if (!LOWERCASE_PATTERN.matcher(potentialPassword).matches()) {
            System.out.println("You don't have a Lowercase Letter!");
            return false;
        }
        if (!DIGITS_PATTERN.matcher(potentialPassword).matches()) {
            System.out.println("You don't have a Digit!");
            return false;
        }
        if (!SPONSOR_PATTERN.matcher(potentialPassword).matches()) {
            System.out.println("You don't have our Sponsor included (It's Schwarz)!");
            return false;
        }
        if (!GEOGUESSR_PATTERN.matcher(potentialPassword).matches()) {
            System.out.println("You forgot to include the correct Country, Which Country is this? https://imgur.com/a/R6mMpnn included! (Don't Cheat :) )");
            return false;
        }
        return true;
    }
}