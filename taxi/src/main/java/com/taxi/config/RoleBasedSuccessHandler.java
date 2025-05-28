package com.taxi.config;

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
public class RoleBasedSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // если есть ROLE_Admin — кидаем на /drivers
        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_Admin"))) {
            response.sendRedirect(request.getContextPath() + "/drivers");
            return;
        }

        // если есть ROLE_User — кидаем на /passengers
        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_User"))) {
            response.sendRedirect(request.getContextPath() + "/passengers");
            return;
        }

        // по умолчанию на /
        response.sendRedirect(request.getContextPath() + "/");
    }
}
