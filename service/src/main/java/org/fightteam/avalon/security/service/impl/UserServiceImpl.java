package org.fightteam.avalon.security.service.impl;

import org.fightteam.avalon.security.data.UserRepository;
import org.fightteam.avalon.security.data.models.*;
import org.fightteam.avalon.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author excalibur
 * @since 0.0.1
 */
@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 载入用户信息
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException 没有该用户
     */
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("==========loadUserByUsername============");
        System.out.println("username = [" + username + "]");

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("couldn't find user by username:" + username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        List<Permission> permissions = user.getPermissions();
        List<Role> roles = user.getRoles();


        for(Permission permission:permissions){
            grantedAuthorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(permission.getName()));

            PermissionGroup permissionGroup = permission.getPermissionGroup();
            if (permissionGroup != null){
                grantedAuthorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(permissionGroup.getName()));
            }
        }
        for (Role role:roles){
            grantedAuthorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(role.getName()));

            RoleGroup roleGroup = role.getRoleGroup();
            if (roleGroup != null){
                grantedAuthorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(roleGroup.getName()));
            }
        }

        /**
         *    * @param username the username presented to the
         *        <code>DaoAuthenticationProvider</code>
         * @param password the password that should be presented to the
         *        <code>DaoAuthenticationProvider</code>
         * @param enabled set to <code>true</code> if the user is enabled
         * @param accountNonExpired set to <code>true</code> if the account has not
         *        expired
         * @param credentialsNonExpired set to <code>true</code> if the credentials
         *        have not expired
         * @param accountNonLocked set to <code>true</code> if the account is not
         *        locked
         * @param authorities the authorities that should be granted to the caller
         *        if they presented the correct username and password and the user
         *        is enabled. Not null.
         */
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isEnabled(),
                user.isAccountNonExpired() ,
                user.isCredentialsNonExpired(),
                user.isAccountNonLocked(),
                grantedAuthorities);
        return userDetails;
    }


    @Override
    public boolean isUsernameExists(String username) {
        return false;
    }

    @Override
    public boolean isEmailExists(String email) {
        return false;
    }

    @Override
    public User registerUser(User user) {

        return userRepository.save(user);
    }
}