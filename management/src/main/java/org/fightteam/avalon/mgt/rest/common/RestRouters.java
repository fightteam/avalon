package org.fightteam.avalon.mgt.rest.common;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * Rest调用接口
 *
 * 采用spring单例实现方便配置
 *
 * @author excalibur
 * @since 0.0.1
 */
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Setter
public class RestRouters {
    private final static String URL_SIGN = "/";

    @Value("${rest.baseUrl}")
    private String baseUrl;

    @Value("${rest.users}")
    private String users;

    @Value("${rest.users}")
    private String usersModel;

    @Value("${rest.roles}")
    private String roles;

    @Value("${rest.roles}")
    private String opterations;

    /**
     * 拼接URL
     *
     * 根据baseURL生成新链接
     *
     * @param rel
     * @return 新链接
     */
    private String connection(String rel){
        StringBuffer buffer = new StringBuffer(baseUrl);
        buffer.append(URL_SIGN);
        buffer.append(rel);
        return buffer.toString();
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUsers() {
        return connection(users);
    }

    public String getRoles() {
        return connection(roles);
    }

    public String getUsersModel() {
        return connection(usersModel);
    }

    public String getOpterations() {
        return connection(opterations);
    }
}
