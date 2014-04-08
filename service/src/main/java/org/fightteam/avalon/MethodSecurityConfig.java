package org.fightteam.avalon;


import org.fightteam.avalon.security.data.PermissionRepository;
import org.fightteam.avalon.security.data.ResourceRepository;
import org.fightteam.avalon.security.data.models.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private AuthenticationManager authenticationManager;
//    @Override
//    protected MethodSecurityExpressionHandler createExpressionHandler() {
//        DefaultMethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
//        //expressionHandler.setPermissionEvaluator();
//        MethodSecurityMetadataSource methodSecurityMetadataSource;
//
//        return expressionHandler;
//    }


    /**
     * 自定义加载 方法权限规则
     *
     * 目前没进行MetadataSource改造，只是重新读取
     *
      * @return
     */
    @Override
    protected MethodSecurityMetadataSource customMethodSecurityMetadataSource() {
        Map<String, List<ConfigAttribute>> methodMap = new HashMap<>();

        permissionRepository.findAll();

        List<ConfigAttribute> configAttributes = new ArrayList<>();
        configAttributes.add(new SecurityConfig("ROLE_VIEWUSERS2"));
        methodMap.put("org.fightteam.avalon.service.ManagerService.add",configAttributes);
        MethodSecurityMetadataSource metadataSource = new MapBasedMethodSecurityMetadataSource(methodMap);

        return metadataSource;
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.parentAuthenticationManager(authenticationManager);
    }
}
