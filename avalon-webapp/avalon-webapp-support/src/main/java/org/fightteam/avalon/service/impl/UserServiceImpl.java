package org.fightteam.avalon.service.impl;

import org.fightteam.avalon.core.entity.domain.User;
import org.fightteam.avalon.rest.exception.data.EmailNotFoundException;
import org.fightteam.avalon.rest.repositroy.UserRepository;
import org.fightteam.avalon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * User业务逻辑实现
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:28
 * 继承了 BasicServiceImpl 的CRUD、分页与排序
 * 继承了 UserDetailsServiceImpl 实现登录
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("aaa");
        }
        return user;
    }

    @Override
    public User findByEmail(String email) throws EmailNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new EmailNotFoundException("aaa");
        }
        return user;
    }

    @Override
    public boolean isisEmailExists() {
        return false;
    }

    @Override
    public boolean isUsernameExists() {
        return false;
    }

    @Override
    public User loginUser(User user, HttpServletRequest request) {
        return null;
    }

    @Override
    public User registerUser(User user, HttpServletRequest request) {
        return null;
    }


}
