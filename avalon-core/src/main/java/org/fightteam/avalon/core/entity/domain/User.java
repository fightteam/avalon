package org.fightteam.avalon.core.entity.domain;


import lombok.Getter;
import lombok.Setter;
import org.fightteam.avalon.core.entity.AbstractEntity;
import org.springframework.data.rest.core.annotation.Description;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统用户
 * 定义了系统用户最简单的基本属性
 * 为了满足系统需求，系统扩展用户都应该继承该类
 *
 * @author excalibur
 * @since 0.0.1
 */
@javax.persistence.Entity
@Table(name = "t_user")
@Getter
@Setter
public class User extends AbstractEntity<Long>{


    //系统帐号采用email 但是为了扩展需求 保留了username
    @Description("dsdsdsd")
    private String username;
    private String email;
    //加密过后的密码 (数据库不储存用户的明文密码)
    @NotNull(message = "not.blank")
    private String password;
    private String salt;
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


}
