package org.fightteam.avalon.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 提供跨域
 *
 * @author excalibur
 * @since 0.0.1
 */
public class CORSFilter {
    private static final Logger logger = LoggerFactory.getLogger(CORSFilter.class);



    public void hasCrosPermission(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("============CORSFilter===============");
        logger.debug("in CORSFilter");
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:9000");
        response.addHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
<<<<<<< HEAD
        response.addHeader("Access-Control-Allow-Headers", "*");
=======
        response.addHeader("Access-Control-Allow-Headers", "Content-Type, WWW-Authenticate, Origin, Accept, Authenticate, X-Requested-With");
>>>>>>> ff7d32616ceac67e69d4db324dde0f23cd310cf2
        response.addHeader("Access-Control-Max-Age", "1800");
        response.addHeader("Access-Control-Allow-Credentials", "true");


    }
}
