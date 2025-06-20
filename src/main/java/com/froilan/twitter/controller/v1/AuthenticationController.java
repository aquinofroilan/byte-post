package com.froilan.twitter.controller.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @PostMapping("/signin")
    public String signIn(@RequestParam String username, @RequestParam String password) {
        System.out.println(username + " " + password);
        logger.info("Sign in endpoint called");
        return "Login endpoint called";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String name, @RequestParam String email, @RequestParam Date birthDate,
                         @RequestParam String password) {
        System.out.println(name + " " + email + " " + birthDate + " " + password);
        logger.info("Sign up endpoint called");
        return "Register endpoint called";
    }

    @PostMapping("/signout")
    public String signOut() {
        logger.info("Sign out endpoint called");
        return "Logout endpoint called";
    }

    @PostMapping("/refresh")
    public String refresh() {
        return "Refresh token endpoint called";
    }

    @PostMapping("/forgot-password")
    public String forgotPassword() {
        logger.info("Forgot password endpoint called");
        return "Forgot password endpoint called";
    }

    @PostMapping("/reset-password")
    public String resetPassword() {
        logger.info("Reset password endpoint called");
        return "Reset password endpoint called";
    }

    @PostMapping("/one-time-password")
    public String oneTimePassword() {
        logger.info("One-time password endpoint called");
        return "One-time password endpoint called";
    }

}
