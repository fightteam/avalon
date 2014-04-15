package org.fightteam.avalon.security.authentication;

import org.fightteam.avalon.security.AvalonUsernamePasswordAuthenticationFilter;
import org.fightteam.avalon.security.vo.Token;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class AvalonAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final String AVALON_TOKEN = "Access-Token";


    private PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("===========onAuthenticationSuccess===========");
        System.out.println(authentication);
        User user = (User) authentication.getPrincipal();
        String username = user.getUsername();
        Token token = new Token(passwordEncoder.encode(username));
        AvalonUsernamePasswordAuthenticationFilter.addCacheUser(token.getToken(), authentication);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        ServletOutputStream out = response.getOutputStream();
        out.print(token.toString());
        out.close();
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public static String getAvalonToken() {
        return AVALON_TOKEN;
    }
}
