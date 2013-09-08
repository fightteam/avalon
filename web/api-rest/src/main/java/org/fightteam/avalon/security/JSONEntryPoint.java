package org.fightteam.avalon.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义错误返回
 * User: faith
 * Date: 13-8-1
 * Time: 下午12:36
 * 不返回页面只是返回一个数据
 */
@Component
public class JSONEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
