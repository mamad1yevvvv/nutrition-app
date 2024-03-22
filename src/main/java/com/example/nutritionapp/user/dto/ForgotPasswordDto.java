package com.example.nutritionapp.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ForgotPasswordDto {
    @Email
    @NotBlank(message = "auth.user.email.required")
    private String email;
    private String password;
    private String confirmPassword;
}
