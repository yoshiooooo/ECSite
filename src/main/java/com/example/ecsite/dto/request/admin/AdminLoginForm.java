package com.example.ecsite.dto.request.admin;

import jakarta.validation.constraints.NotBlank;

public class AdminLoginForm {

    @NotBlank(message = "ユーザーIDは必須です")
    private String username;

    @NotBlank(message = "パスワードは必須です")
    private String password;

    // getter/setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
