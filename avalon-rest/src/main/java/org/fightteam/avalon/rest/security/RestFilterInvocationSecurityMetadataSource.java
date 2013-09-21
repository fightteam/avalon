package org.fightteam.avalon.rest.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 描述信息
 *
 * @author excalibur
 * @since 0.0.1
 */
public class RestFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;


        @PostConstruct
        public void setUp(){
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            loadResources();
        }
        /**
         * 根据请求判断获取权限
         * @param o
         * @return
         * @throws IllegalArgumentException
         */
        @Override
        public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {

                return null;
        }

        /**
         * 获取所有权限定义
         * @return
         */
        @Override
        public Collection<ConfigAttribute> getAllConfigAttributes() {

                return null;
        }

        @Override
        public boolean supports(Class<?> aClass) {
                return true;
        }

    private void loadResources(){
        List<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
        SecurityConfig config = new SecurityConfig("ROLE_USER");

        ConfigAttribute configAttribute = new SecurityConfig("ROLE_USER");
       // resourceMap.put("/")
    }
}
