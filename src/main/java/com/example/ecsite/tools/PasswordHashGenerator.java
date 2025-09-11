package com.example.ecsite.tools;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {

    public static void main(String[] args) {
        String rawPassword = "aaa@@@111";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // 強度12（推奨）

        String hashedPassword = encoder.encode(rawPassword);
        System.out.println("Hashed password: " + hashedPassword);
    }
}