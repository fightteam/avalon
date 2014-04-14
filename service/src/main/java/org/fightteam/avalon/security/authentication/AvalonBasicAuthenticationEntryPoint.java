package org.fightteam.avalon.security.authentication;

import org.fightteam.avalon.security.exception.UnauthenticatedException;
import org.fightteam.avalon.security.vo.Message;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.ELRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理异常
 *
 * @author faith
 * @since 0.0.1
 */
public class AvalonBasicAuthenticationEntryPoint implements AuthenticationEntryPoint {


    //~ Instance fields ================================================================================================

    private static final String HEADER_TOKEN = "avalon_token";
    private static final RequestMatcher requestMatcher = new ELRequestMatcher(
            "hasHeader('X-Requested-With','XMLHttpRequest')");

    //~ Methods ========================================================================================================

    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {

        // 如果来自ajax
//        if (isRestRequest(request)) {
//            System.out.println("isRestRequest");
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//        }else{
//
//            response.addHeader("WWW-Authenticate", "Basic realm=\"" + realmName + "\"");
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
//
//        }
        String token = request.getHeader(HEADER_TOKEN);
        ServletOutputStream out = response.getOutputStream();

        // 没有登陆信息
        if (token == null){
              response.setHeader("Content-Type", "application/json");
              Message message = new Message();
            message.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            message.setMessage("Unauthorized");
            out.print(message.toString());

//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        }else{
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
        }
        out.close();

    }


    protected boolean isRestRequest(HttpServletRequest request) {
        return requestMatcher.matches(request);
    }
}
