package org.fightteam.avalon.security;

import org.fightteam.avalon.security.data.ResourceRepository;
import org.fightteam.avalon.security.data.models.Operation;
import org.fightteam.avalon.security.data.models.Permission;
import org.fightteam.avalon.security.data.models.Resource;
import org.fightteam.avalon.security.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.config.http.MatcherType;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.ExpressionBasedFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.*;
import org.springframework.stereotype.Component;
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
@Component
public class AvalonSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private final static Logger logger = LoggerFactory.getLogger(AvalonSecurityMetadataSource.class);
    @Autowired
    private ResourceService resourceService;

    private final LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = new LinkedHashMap<>();

    // 自定义扩展
    private FilterInvocationSecurityMetadataSource metadataSource;

    // web 默认表达式
    private SecurityExpressionHandler<FilterInvocation> expressionHandler = new DefaultWebSecurityExpressionHandler();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        System.out.println("===============get==============");
        System.out.println("object = [" + object + "]");
        System.out.println(metadataSource.getAttributes(object));
        return metadataSource.getAttributes(object);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        System.out.println("===============getAllConfigAttributes==============");

        return metadataSource.getAllConfigAttributes();
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @PostConstruct
    // URL权限载入
    public void load(){

        Map<String, String> map = resourceService.findAllURL();
        // URL权限载入
        for(String key : map.keySet()){
            logger.debug("load permission matcher :" + key);
            logger.debug("load permission resources :" + map.get(key));
            String [] matcher = key.split("@");
            RequestMatcher requestMatcher = null;
            // 判断什么匹配器
            String path = matcher[0];
            String method = matcher.length == 2 ? ( matcher[1].equals("*")? null: matcher[1] ): null;

            if (("/**".equals(path) || "**".equals(path)) && method == null){
                requestMatcher = AnyRequestMatcher.INSTANCE;
            }else if( path.indexOf("^") > -1 || path.indexOf("$") > -1){
                requestMatcher = new RegexRequestMatcher(path, method);
            }else{
                requestMatcher = new AntPathRequestMatcher(path, method);
            }

            Collection<ConfigAttribute> configAttributes = SecurityConfig.createList(map.get(key));
            requestMap.put(requestMatcher, configAttributes);
        }
        System.out.println(requestMap);
        // 初始化资源
        metadataSource = new ExpressionBasedFilterInvocationSecurityMetadataSource(requestMap, expressionHandler);
    }
}
