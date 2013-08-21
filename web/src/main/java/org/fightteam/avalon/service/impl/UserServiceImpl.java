package org.fightteam.avalon.service.impl;

import org.fightteam.avalon.core.entity.domain.User;
import org.fightteam.avalon.repositroy.UserRepository;
import org.fightteam.avalon.exception.data.EmailNotFoundException;
import org.fightteam.avalon.service.UserService;
import org.fightteam.avalon.tools.persistence.service.impl.BasicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * User业务逻辑实现
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:28
 * 继承了 BasicServiceImpl 的CRUD、分页与排序
 * 继承了 UserDetailsService 实现登录
 */
@Service
public class UserServiceImpl extends BasicServiceImpl<User,Long> implements UserService,UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public void setUp() {
        this.pagingAndSortingRepository = userRepository;
    }
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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findByUsername(username);
        System.out.println("==========="+username);
        return user;
    }
}
