package com.taxi.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import java.io.IOException;

public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        // получаем первую (и единственную) роль и приводим к верхнему регистру
        String role = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst()
                .orElse("")
                .toUpperCase();

        if ("ADMIN".equals(role)) {
            response.sendRedirect("/drivers");
        } else if ("USER".equals(role)) {
            response.sendRedirect("/passengers");
        } else {
            // на всякий случай
            response.sendRedirect("/login?error");
        }
    }
}
