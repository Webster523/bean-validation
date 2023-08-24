package com.example.bean;

public class ValidationTest {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        traditionValidationTest(userInfo);
    }

    private static void traditionValidationTest(UserInfo userInfo) {
        String name = userInfo.getName();
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            throw new RuntimeException("The property name cannot pass the validation.");
        }

        Integer age = userInfo.getAge();
        boolean ageValid = 1 <= age && age <= 800;
        if (!ageValid) {
            throw new RuntimeException("The property age cannot pass the validation.");
        }
    }
}
