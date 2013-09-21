package org.fightteam.avalon.core.entity.domain;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.avalon.core.entity.AbstractEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统角色定义类
 *
 * 该类中定义了全部用户的角色定义，
 * 所有角色都基于权限
 *
 * @author excalibur
 * @since 0.0.1
 */
@javax.persistence.Entity
@Table(name = "t_role")
@Getter
@Setter
public class Role extends AbstractEntity<Long> {
    //角色的名称  这个名称会用权限判断
    private String name;
    //角色显色名称
    private String title;
    //该角色的用户
    @OneToMany(mappedBy = "role")
    private Set<User> users;

    private boolean enable;
    //该角色的权限
    @ManyToMany
    @JoinTable(name = "t_roles_authorities",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    private Set<Authority> authorities;

    //继承权限实现
    @ManyToOne(targetEntity = Role.class)
    private Role parent;
    @OneToMany(mappedBy = "parent")
    private Set<Role> children;

    public Role() {
        this.users = new HashSet<User>();
        this.authorities = new HashSet<Authority>();
        this.children = new HashSet<Role>();
        this.enable = true;
    }


}
