package com.example.trainingapp.controllers.auth;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordBecrypt {
    public static void main(String[] args) {
          PasswordEncoder passwordEncoder =new BCryptPasswordEncoder();
        String pass = passwordEncoder.encode("premium");
        System.out.println(pass);
    }
}
