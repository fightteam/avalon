package org.fightteam.avalon.web.filter;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 扩展加载静态资源类
 * User: faith
 * Date: 13-8-12
 * Time: 下午5:16
 * 实现加载可以判断版本
 */
public class ResourceLoadFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String var = request.getParameter("var");

    }
}
