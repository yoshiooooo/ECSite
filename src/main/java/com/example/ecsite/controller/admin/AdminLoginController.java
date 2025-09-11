package com.example.ecsite.controller.admin;

import com.example.ecsite.service.admin.AdminAuthService;
import com.example.ecsite.dto.request.admin.AdminLoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    private final AdminAuthService adminAuthService;

    @Autowired
    public AdminLoginController(AdminAuthService adminAuthService) {
        this.adminAuthService = adminAuthService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("adminLoginForm", new AdminLoginForm());
        return "admin/login"; // login.htmlなどのテンプレート
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AdminLoginForm form, Model model) {
        boolean success = adminAuthService.authenticate(form.getUsername(), form.getPassword());

        if (!success) {
            model.addAttribute("error", "ユーザーIDまたはパスワードが正しくありません");
            return "admin/login";
        }

        // 認証成功時の処理（セッション格納など）
        return "redirect:/admin/dashboard";
    }
}
