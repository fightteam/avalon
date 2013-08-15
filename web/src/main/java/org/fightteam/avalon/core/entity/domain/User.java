package org.fightteam.avalon.core.entity.domain;

import org.fightteam.avalon.core.entity.Entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统用户
 * User: faith
 * Date: 13-7-1
 * Time: 下午5:51
 * 定义了系统用户最简单的基本属性
 * 为了满足系统需求，系统扩展用户都应该继承该类
 */
@javax.persistence.Entity
@Table(name = "t_user")
public class User extends Entity<Long> implements UserDetails{


    //系统帐号采用email 但是为了扩展需求 保留了username
    private String username;
    private String email;
    //加密过后的密码 (数据库不储存用户的明文密码)
    private String password;
    //用户及实际姓名
    private String name;
    //帐号是否失效
    private boolean accountNonExpired;
    //帐号是否锁定
    private boolean accountNonLocked;
    //用户的凭证(密码)是否过期
    private boolean credentialsNonExpired;
    //用户是否可用
    private boolean enabled;
    //用户权限
    @ManyToMany
    @JoinTable(name = "t_users_authorities",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    private Set<Authority> authorities;
    //用户角色
    @ManyToOne(targetEntity = Role.class)
    private Role role;

    public User() {
        this.authorities = new HashSet<Authority>();
        this.enabled = true;
    }

    /*=============================get and set methods==============================================*/


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
