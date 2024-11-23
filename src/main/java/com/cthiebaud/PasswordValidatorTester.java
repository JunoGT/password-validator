package com.cthiebaud;

import java.io.Console;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;

import com.cthiebaud.passwordvalidator.PasswordValidator;
import com.cthiebaud.passwordvalidator.ValidationResult;

public class PasswordValidatorTester {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Argument missing: <path-to-the-jar-containing-your-implementation>");
            return;
        }

        String jarPath = args[0]; // Path to the student's JAR file

        // Load the student's JAR file
        File jarFile = new File(jarPath);
        if (!jarFile.exists()) {
            System.out.println("JAR file not found!");
            return;
        }

        // Find classes implementing PasswordValidator
        List<Class<?>> validatorClasses = findPasswordValidatorClasses(jarFile);

        // Ensure exactly one implementation is found
        if (validatorClasses.size() != 1) {
            System.out.println("Error: Expected exactly one implementation of PasswordValidator, found: "
                    + validatorClasses.size());
            return;
        }

        // Use the found implementation
        Class<?> clazz = validatorClasses.get(0);

        // Create an instance of the student's implementation
        PasswordValidator validator = (PasswordValidator) clazz.getDeclaredConstructor().newInstance();

        // Get console for hidden input
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available. Please run this in a console.");
            return;
        }

        // Loop to validate passwords
        while (true) {
            char[] passwordArray = console.readPassword("Enter a password to validate (or type 'quit' to exit): ");
            String password = new String(passwordArray);

            // Check if the user wants to quit
            if ("quit".equalsIgnoreCase(password)) {
                System.out.println("Exiting the program.");
                break;
            }

            // Validate the password using the student's implementation
            ValidationResult result = validator.validate(password);

            // Display the result
            if (result.isValid()) {
                printBigOK();
                break;
            } else {
                System.out.println("Password is invalid: " + result.message());
            }
        }
    }

    private static List<Class<?>> findPasswordValidatorClasses(File jarFile) throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        try (JarFile jar = new JarFile(jarFile)) {
            // Iterate through all entries in the JAR file
            jar.stream().forEach(entry -> {
                if (entry.getName().endsWith(".class")) {
                    String className = entry.getName().replace("/", ".").substring(0, entry.getName().length() - 6);
                    try {
                        // Load the class
                        Class<?> clazz = Class.forName(className, false,
                                URLClassLoader.newInstance(new URL[] { jarFile.toURI().toURL() }));
                        // Check if it implements PasswordValidator and is not an interface or abstract
                        // class
                        if (PasswordValidator.class.isAssignableFrom(clazz)
                                && !clazz.isInterface()
                                && !java.lang.reflect.Modifier.isAbstract(clazz.getModifiers())) {
                            classes.add(clazz);
                        }
                    } catch (Exception e) {
                        // Handle exception silently; it can occur if the class cannot be loaded
                    }
                }
            });
        }
        return classes;
    }

    private static void printBigOK() {
        System.out.println("  ______    __  ___  __  ");
        System.out.println(" /  __  \\  |  |/  / |  | ");
        System.out.println("|  |  |  | |  '  /  |  | ");
        System.out.println("|  |  |  | |    <   |  | ");
        System.out.println("|  `--'  | |  .  \\  |__| ");
        System.out.println(" \\______/  |__|\\__\\ (__) ");
        System.out.println("                         ");
    }
}