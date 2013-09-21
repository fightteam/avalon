package org.fightteam.avalon.rest.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 描述信息
 *
 * @author excalibur
 * @since 0.0.1
 */
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
          // 设置按照json数据返回
        response.setContentType("application/json,application/x-spring-data-compact+json");
        PrintWriter out = response.getWriter();
        out.print(e.getMessage());
        out.flush();
        out.close();
    }
}
