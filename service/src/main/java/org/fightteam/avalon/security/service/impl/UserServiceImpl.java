package org.fightteam.avalon.security.service.impl;

import org.fightteam.avalon.data.ConsumerRepository;
import org.fightteam.avalon.data.models.Consumer;
import org.fightteam.avalon.security.data.RoleGroupRepository;
import org.fightteam.avalon.security.data.RoleRepository;
import org.fightteam.avalon.security.data.UserRepository;
import org.fightteam.avalon.security.data.models.*;
import org.fightteam.avalon.security.service.UserService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyAuthoritiesMapper;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    private static final String REGISTER_GROUP = "GROUP_USER";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConsumerRepository consumerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleGroupRepository roleGroupRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
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

        Set<Permission> permissions = new HashSet<>();
        Set<Role> roles = new HashSet<>();

        if (user.getPermissions() != null){
            permissions.addAll(user.getPermissions());
        }

        PermissionGroup permissionGroup = user.getPermissionGroup();
        if (permissionGroup != null){
            if (permissionGroup.getPermissions() != null){
                permissions.addAll(permissionGroup.getPermissions());
            }
            PermissionGroup parent = null;
            do {
                parent = permissionGroup.getParent();
                if (parent != null && parent.getPermissions() != null){
                    permissions.addAll(parent.getPermissions());
                }
            }while (parent != null);



        }

        if (user.getRoles() != null){
            roles.addAll(user.getRoles());
        }

        RoleGroup roleGroup = user.getRoleGroup();
        if (roleGroup != null){
            if (roleGroup.getRoles() != null){
                roles.addAll(roleGroup.getRoles());
            }

            RoleGroup parent = null;
            do {
                parent = roleGroup.getParent();

                if (parent != null && parent.getRoles() != null){
                    roles.addAll(parent.getRoles());
                }
            }while (parent != null);
        }


        // 构造权限
        for(Permission permission : permissions){
            grantedAuthorities.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(permission.getName()));
        }
        for(Role role : roles){
            System.out.println(role.getName());
            grantedAuthorities.addAll(AuthorityUtils.createAuthorityList("ROLE_"+role.getName()));
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
    public Consumer registerUser(Consumer consumer) {
        RoleGroup userGroup = roleGroupRepository.findByName(REGISTER_GROUP);
        consumer.setRoleGroup(userGroup);
        consumer.setPassword(passwordEncoder.encode(consumer.getPassword()));
        consumer.setRegisteTime(new DateTime());
        return consumerRepository.save(consumer);
    }
}