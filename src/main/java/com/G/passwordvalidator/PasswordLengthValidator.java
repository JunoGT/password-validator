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
 *   <li>Contains the specified sponsor keyword (e.g., "schwarz")</li>
 *   <li>Contains the specified GeoGuesser country (e.g., "Sweden")</li>
 * </ul>
 * These requirements add both security and flexibility to the password policy.
 */
public class PasswordLengthValidator implements PasswordValidator {

    // Regular expression patterns for password requirements
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*");
    private static final Pattern DIGITS_PATTERN = Pattern.compile(".*\\d.*");

    private final String sponsorKeyword; // Configurable sponsor keyword
    private final String geoGuesserCountry; // Configurable GeoGuesser country

    /**
     * Constructor to initialize the validator with configurable sponsor and GeoGuesser country.
     *
     * @param sponsorKeyword the sponsor keyword required in the password
     * @param geoGuesserCountry the GeoGuesser country required in the password
     */
    public PasswordLengthValidator(String sponsorKeyword, String geoGuesserCountry) {
        this.sponsorKeyword = sponsorKeyword;
        this.geoGuesserCountry = geoGuesserCountry;
    }

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
        if (!Pattern.compile(".*" + Pattern.quote(sponsorKeyword) + ".*", Pattern.CASE_INSENSITIVE).matcher(potentialPassword).matches()) {
            return new ValidationResult(false, "You don't have our Sponsor included (It's " + sponsorKeyword + ")!");
        }
        if (!Pattern.compile(".*" + Pattern.quote(geoGuesserCountry) + ".*", Pattern.CASE_INSENSITIVE).matcher(potentialPassword).matches()) {
            return new ValidationResult(false, "You forgot to include the correct Country (" + geoGuesserCountry + ")!");
        }
        return new ValidationResult(true, "");
    }
}
    
