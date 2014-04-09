package org.fightteam.avalon.security;

import org.fightteam.avalon.security.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Service
@Transactional
public class AvalonSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private ResourceService resourceService;

    private final LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<>();

    // 框架默认
    private FilterInvocationSecurityMetadataSource defaultSecurityMetadataSource;

    // 自定义扩展
    private FilterInvocationSecurityMetadataSource customSecurityMetadataSource;

    // web 默认表达式
    private SecurityExpressionHandler<FilterInvocation> expressionHandler = new DefaultWebSecurityExpressionHandler();


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        System.out.println("===============get==============");
        // 先获取默认的
        Collection<ConfigAttribute> defaultSecurityMetadataSourceAttributes = defaultSecurityMetadataSource.getAttributes(object);
        // 自定义扩展的
        Collection<ConfigAttribute> customSecurityMetadataSourceAttributes = customSecurityMetadataSource.getAttributes(object);

        defaultSecurityMetadataSourceAttributes.addAll(customSecurityMetadataSourceAttributes);

        return defaultSecurityMetadataSourceAttributes;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        System.out.println("===============getAllConfigAttributes==============");
        // 先获取默认的
        Collection<ConfigAttribute> defaultSecurityMetadataSourceAttributes = defaultSecurityMetadataSource.getAllConfigAttributes();
        // 自定义扩展的
        Collection<ConfigAttribute> customSecurityMetadataSourceAttributes = customSecurityMetadataSource.getAllConfigAttributes();

        defaultSecurityMetadataSourceAttributes.addAll(customSecurityMetadataSourceAttributes);

        return defaultSecurityMetadataSourceAttributes;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    public void setDefaultSecurityMetadataSource(FilterInvocationSecurityMetadataSource defaultSecurityMetadataSource) {
        this.defaultSecurityMetadataSource = defaultSecurityMetadataSource;
    }

    @PostConstruct
    // 载入数据库资源
    public void load(){

        Map<String, String> map = resourceService.findAllURL();
        // URL权限载入
        for(String key : map.keySet()){
            String [] matcher = key.split(",");
            RequestMatcher requestMatcher = null;
            if (!matcher[1].equals("*")){
                requestMatcher = new AntPathRequestMatcher(matcher[0], matcher[1]);
            }else {
                requestMatcher = new AntPathRequestMatcher(matcher[0]);
            }
            Collection<ConfigAttribute> configAttributes = SecurityConfig.createListFromCommaDelimitedString(map.get(key));
            requestMap.put(requestMatcher, configAttributes);
        }

        // 初始化资源
        customSecurityMetadataSource = new ExpressionBasedFilterInvocationSecurityMetadataSource(requestMap, expressionHandler);

    }
}
