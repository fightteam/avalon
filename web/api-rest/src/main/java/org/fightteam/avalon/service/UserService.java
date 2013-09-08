package org.fightteam.avalon.service;

import org.fightteam.avalon.core.entity.domain.User;
import org.fightteam.avalon.exception.data.EmailNotFoundException;
import org.fightteam.avalon.tools.persistence.service.BasicService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * User业务逻辑接口
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:28
 * 继承
 */
public interface UserService extends BasicService<User,Long>{
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    public User findByUsername(String username)throws UsernameNotFoundException;

    /**
     * 根据email查找用户
     * @param email
     * @return
     * @throws EmailNotFoundException
     */
    public User findByEmail(String email)throws EmailNotFoundException;

    public User findByUser(User user,String message);
}
