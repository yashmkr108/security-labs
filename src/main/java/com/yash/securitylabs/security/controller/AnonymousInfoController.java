package com.yash.securitylabs.security.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnonymousInfoController {

    @GetMapping("/api/anonymous-info")
    public String anonymousInfo() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        boolean anonymous =
                authentication instanceof AnonymousAuthenticationToken;

        return "Authentication type: "
                + (authentication == null
                ? "null"
                : authentication.getClass().getSimpleName())
                + ", Is anonymous: " + anonymous
                + ", Is authenticated: "
                + (authentication != null
                && authentication.isAuthenticated());
    }
}