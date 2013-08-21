package org.fightteam.avalon.core.entity.domain;

import org.fightteam.avalon.core.entity.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统角色定义类
 * User: faith
 * Date: 13-7-1
 * Time: 下午5:56
 * 该类中定义了全部用户的角色定义，
 * 所有角色都基于权限
 */
@javax.persistence.Entity
@Table(name = "t_role")
public class Role extends Entity<Long>{
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

     /*=============================get and set methods==============================================*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Role getParent() {
        return parent;
    }

    public void setParent(Role parent) {
        this.parent = parent;
    }

    public Set<Role> getChildren() {
        return children;
    }

    public void setChildren(Set<Role> children) {
        this.children = children;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
