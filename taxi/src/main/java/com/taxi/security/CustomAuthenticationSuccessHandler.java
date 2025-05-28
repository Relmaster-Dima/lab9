package com.taxi.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {

        // получаем все роли пользователя
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // если есть роль Admin — редиректим на /drivers
        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("Admin"))) {
            response.sendRedirect("/drivers");
            return;
        }
        // иначе, если есть роль User — на /passengers
        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("User"))) {
            response.sendRedirect("/passengers");
            return;
        }

        // на всякий случай — на главную
        response.sendRedirect("/");
    }
}
