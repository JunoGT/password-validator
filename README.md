# Password Validator

## Project Overview
This project includes a `PasswordValidator` interface along with a custom implementation `CustomPasswordValidator` that validates passwords based on a mix of security and unique requirements. 

## Security Considerations
This criterion ensures passwords have sufficient complexity to resist brute-force attacks and dictionary attacks. The additional requirements besides minimum lenght and character variety add a playful, personalized element to the policy without compromising security.

## Components


This project is organized into the following main components:

### CustomPasswordValidator
Implements a `PasswordValidator` ([interface](https://github.com/athenaeum-brew/password-validator)) and contains the logic to validate passwords. The criteria include:
- Must be at least 8 characters long.
- Must contain at least one uppercase letter, one lowercase letter, and one numeric digit.
- Must contain our sponsor
- Must contain the solution to our GeoGuessr Challenge

### ValidatorTest
A JUnit test suite that verifies the functionality of `CustomPasswordValidator`. It uses annotated test methods to validate various password scenarios, ensuring correct behavior for both valid and invalid passwords.

## Getting Started 
- **Build**: Run `mvn package` to create the JAR file.
- **Test**: Run `mvn test` to execute unit tests.


## Note
This validator is designed to enhance security while adding a creative touch. You might need a few tries before your password will be accepted 😉.
