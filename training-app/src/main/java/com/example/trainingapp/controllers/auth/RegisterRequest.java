package com.example.trainingapp.controllers.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String login;
    private String email;
    private String password;
    private LocalDate birthDate;
    private double height;
    private double weight;

    private boolean sex;
    private double palfactor;
}
