package com.G.passwordvalidator;

public class test {
    public static void main(String[] args) {
        CustomPasswordValidator validator = new CustomPasswordValidator();
        boolean isValid = validator.isValid("SamplePassword1#sjavachwarz");
        System.out.println("Is the password valid? " + isValid);
    }
}