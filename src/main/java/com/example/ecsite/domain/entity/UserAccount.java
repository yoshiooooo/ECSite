package com.example.ecsite.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "user_account", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email"),
    @UniqueConstraint(columnNames = "username")
})
@Data
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String username;

    @NotBlank
    @Email
    @Column(length = 255, nullable = false)
    private String email;

    @NotBlank
    @Column(length = 255, nullable = false)
    private String password;

    @Column(name = "admin_flag", nullable = false)
    private boolean adminFlag;
}
