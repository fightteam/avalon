package org.fightteam.avalon.security;

import org.fightteam.avalon.security.authentication.AvalonAuthenticationSuccessHandler;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.ELRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public class AvalonUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    //~ Static fields/initializers =====================================================================================

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "username";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";
    /**
     * @deprecated If you want to retain the username, cache it in a customized {@code AuthenticationFailureHandler}
     */
    @Deprecated
    public static final String SPRING_SECURITY_LAST_USERNAME_KEY = "SPRING_SECURITY_LAST_USERNAME";

    private String usernameParameter = SPRING_SECURITY_FORM_USERNAME_KEY;
    private String passwordParameter = SPRING_SECURITY_FORM_PASSWORD_KEY;
    private boolean postOnly = true;

    private static LinkedHashMap<String, Authentication> cacheUser = new LinkedHashMap<>();

    private static final RequestMatcher requestMatcher = new ELRequestMatcher(
            "hasHeader('X-Requested-With','XMLHttpRequest')");
    //~ Constructors ===================================================================================================

    public AvalonUsernamePasswordAuthenticationFilter() {
        super("/login");
    }

    //~ Methods ========================================================================================================

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("request = [" + request + "], response = [" + response + "]");
//        if (postOnly && !request.getMethod().equals("POST")) {
//            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
//        }


        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);

        // Allow subclasses to set the "details" property
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }


    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("===========doFilter===============");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        // 复杂请求的预处理  主要是跨域是否有权限
        System.out.println(request.getMethod());

        response.addHeader("Access-Control-Allow-Origin", "http://localhost:9000");
        response.addHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, PATCH");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type, WWW-Authenticate, Origin, Accept, Authenticate, X-Requested-With, Access-Token");
        response.addHeader("Access-Control-Max-Age", "1800");
        response.addHeader("Access-Control-Allow-Credentials", "true");

        // 针对复杂请求跨域
        if (request.getMethod().equals("OPTIONS")){

            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return;
        }
        String token = request.getHeader(AvalonAuthenticationSuccessHandler.getAvalonToken());
        System.out.println("--------------token--------------");
        System.out.println(token);
        UsernamePasswordAuthenticationToken authRequest = (UsernamePasswordAuthenticationToken) cacheUser.get(token);

        // 如果已经有信息了，那么设置登陆信息
        if (authRequest != null){
            SecurityContext securityContext = new SecurityContextImpl();
            securityContext.setAuthentication(authRequest);
            SecurityContextHolder.setContext(securityContext);
            chain.doFilter(request, response);
            return;

        // 否则进行登陆
        }else{
            super.doFilter(req, res, chain);
        }

    }

    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(passwordParameter);
    }


    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter(usernameParameter);
    }


    protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }


    public void setUsernameParameter(String usernameParameter) {
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.usernameParameter = usernameParameter;
    }


    public void setPasswordParameter(String passwordParameter) {
        Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
        this.passwordParameter = passwordParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getUsernameParameter() {
        return usernameParameter;
    }

    public final String getPasswordParameter() {
        return passwordParameter;
    }

    protected boolean isRestRequest(HttpServletRequest request) {
        return requestMatcher.matches(request);
    }

    public static void addCacheUser(String token, Authentication authentication){
        cacheUser.put(token, authentication);
    }
}
