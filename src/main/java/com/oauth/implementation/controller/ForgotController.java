package com.oauth.implementation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oauth.implementation.service.UserService;
@Controller
@RequestMapping("/forgot")
public class ForgotController {
    @Autowired
    private UserService userService;
    @PostMapping
    public String forgotPassword(@RequestParam("email") String email) {
        userService.createPasswordResetTokenForUser(email);
       // return ResponseEntity.ok("Password reset instructions sent to your email.");
     return "redirect:/forgetPassword";
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestParam("token") String token, @RequestParam("password") String password) {
        userService.resetPassword(token, password);
        return ResponseEntity.ok("Password successfully reset.");
    }
}
