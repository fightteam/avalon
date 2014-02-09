package org.fightteam.avalon.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 权限认证资源载入
 *
 * 可以基于数据库载入，或者缓存
 *
 * @author excalibur
 * @since 0.0.1
 */

public class UserDetailsServiceImpl implements UserDetailsService {


    /**
     * 基于username载入用户和权限，
     * 并未认证只是一个信息的载入。
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
