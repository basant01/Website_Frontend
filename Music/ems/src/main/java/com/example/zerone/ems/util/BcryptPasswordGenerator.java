package com.example.zerone.ems.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encryptedUserPassword = passwordEncoder.encode("user");
        String encryptedAdminPassword = passwordEncoder.encode("adminuser");

        System.out.println(encryptedUserPassword );
        System.out.println(encryptedAdminPassword );

        System.out.println(passwordEncoder.matches("adminuser", encryptedAdminPassword));
    }
}