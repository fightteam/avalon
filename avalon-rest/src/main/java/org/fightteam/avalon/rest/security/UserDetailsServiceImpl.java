package org.fightteam.avalon.rest.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 描述信息
 *
 * @author excalibur
 * @since 0.0.1
 */
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("999999999999999999999999999");
        return null;
    }
}
