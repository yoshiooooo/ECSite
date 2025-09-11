package com.example.ecsite.dto.response.admin;

public record AdminLoginDto(
    Long id,
    String username,
    String email,
    String password,
    boolean adminFlag
) {}