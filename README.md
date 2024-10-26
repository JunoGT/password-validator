# Password Validator

## Project Overview
This project implements a `PasswordValidator` interface that validates passwords based on the following criteria:
- Must be at least 8 characters long.
- Must contain at least one uppercase letter, one lowercase letter, and one numeric digit.

## Security Considerations
This criterion ensures passwords have sufficient complexity to resist brute-force attacks and dictionary attacks.

## Getting Started
- **Build**: Run `mvn package` to create the JAR file.
- **Test**: Run `mvn test` to execute unit tests.

## Usage
To use this validator in your project:
```java
PasswordValidator validator = new CustomPasswordValidator();
boolean isValid = validator.isValid("SamplePassword1");
