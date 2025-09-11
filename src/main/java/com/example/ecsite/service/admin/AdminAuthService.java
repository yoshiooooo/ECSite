package com.example.ecsite.service.admin;

import com.example.ecsite.domain.entity.UserAccount;
import com.example.ecsite.domain.repository.admin.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthService {

    private final AdminUserRepository adminUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminAuthService(AdminUserRepository adminUserRepository, PasswordEncoder passwordEncoder) {
        this.adminUserRepository = adminUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean authenticate(String username, String rawPassword) {
        return adminUserRepository.findByUsername(username)
            .filter(UserAccount::isAdminFlag) // 管理者かどうか
            .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword())) // パスワード一致
            .isPresent(); // 両方満たせば true
    }
}
