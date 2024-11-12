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
 *   <li>Contains on of our chosen Sponsors</li>
 * </ul>
 * These requirements add both security and a bit of comedy to the password policy.
 */

public class CustomPasswordValidator implements PasswordValidator {
    // Regular expression patterns for password requirements
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile(".*[A-Z].*");
    private static final Pattern LOWERCASE_PATTERN = Pattern.compile(".*[a-z].*");
    private static final Pattern DIGITS_PATTERN = Pattern.compile(".*\\d.*");
    //Add Sponsor here
    private static final Pattern SPONSOR_PATTERN = Pattern.compile(".*schwarz.*", Pattern.CASE_INSENSITIVE);

    private static final Pattern GEOGUESSR_PATTERN = Pattern.compile(".*sweden.*", Pattern.CASE_INSENSITIVE);
    /**
    * @param password the password to validate
     * @return {@code true} if the password meets all criteria; {@code false} otherwise
     */



    @Override
    public boolean isValid(String password) {
        //Check minimum length and if null
        if (password != null && !password.isEmpty()) {
            if (password.length() >= 8) {

                //Check one uppercase letter
                if (UPPERCASE_PATTERN.matcher(password).matches()) {

                    //Check on lowercase letter
                    if (LOWERCASE_PATTERN.matcher(password).matches()) {

                        //Check one digit
                        if (DIGITS_PATTERN.matcher(password).matches()) {

                                //Check for Sponsor
                                if (SPONSOR_PATTERN.matcher(password).matches()) {

                                    //Check for Geoguess
                                    if (GEOGUESSR_PATTERN.matcher(password).matches()) {

                                        return true;
                                    } else {
                                        System.out.println("You dont havent included the correct Country, Which Country is this? https://imgur.com/a/R6mMpnn included! (Dont Cheat :))");
                                        return false;
                                    }
                                } else {
                                    System.out.println("You dont have our Sponsor included (Its Schwarz)!");
                                    return false;
                                }
                        } else {
                            System.out.println("You dont have a Digit!");
                            return false;
                        }
                    }else {
                        System.out.println("You dont have a Lowercase Letter!");
                        return false;
                    }
                } else {
                    System.out.println("You dont have an Uppercase Letter!");
                    return false;
                }
            } else {
                System.out.println("Your Password is too short!");
                return false;
            }
        }else {
            System.out.println("You need to enter a Password!");
            return false;
        }
    }
}