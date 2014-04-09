package org.fightteam.avalon;


import org.fightteam.avalon.security.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.method.MapBasedMethodSecurityMetadataSource;
import org.springframework.security.access.method.MethodSecurityMetadataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

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
    private ResourceService resourceService;


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

        // 方法权限载入
//        for(Resource resource : resources){
//            if (resource.getResourceType() != ResourceType.METHOD && !resource.isEnable()){
//                continue;
//            }
//
//            List<Permission> permissions = resource.getPermissions();
//            if (permissions.size() == 0){
//                continue;
//            }
//            List<ConfigAttribute> configAttributes = new ArrayList<>();
//            for(Permission permission : permissions){
//                if (!permission.isEnable()){
//                    continue;
//                }
//                configAttributes.add(new SecurityConfig(permission.getName()));
//            }
//            methodMap.put(resource.getName(), configAttributes);
//        }

        MethodSecurityMetadataSource metadataSource = new MapBasedMethodSecurityMetadataSource(methodMap);

        return metadataSource;
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.parentAuthenticationManager(authenticationManager);
    }
}
