package org.fightteam.avalon.service;

import org.fightteam.avalon.core.entity.domain.User;
import org.fightteam.avalon.rest.exception.data.EmailNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * User业务逻辑接口
 *
 * user相关的业务逻辑接口
 *
 * @author excalibur
 * @since 0.0.1
 */
public interface UserService{
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     * @throws {@link org.springframework.security.core.userdetails.UsernameNotFoundException}
     */
    User findByUsername(String username)throws UsernameNotFoundException;

    /**
     * 根据email查找用户
     * @param email
     * @return
     * @throws {@link org.fightteam.avalon.rest.exception.data.EmailNotFoundException}
     */
    User findByEmail(String email)throws EmailNotFoundException;

    /**
     * 判断email是否存在于系统
     * @return true 存在 false 不存在
     */
    boolean isisEmailExists();

    /**
     * 判断username是否存在与系统
     * @return true 存在 false 不存在
     */
    boolean isUsernameExists();

    /**
     * 用户登录
     * @param user
     * @param request
     * @return
     */
    User loginUser(User user, HttpServletRequest request);

    /**
     * 用户注册
     * @param user
     * @param request
     * @return
     */
    User registerUser(User user, HttpServletRequest request);
}
