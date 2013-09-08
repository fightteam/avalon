package org.fightteam.avalon.core.entity.domain;

import org.fightteam.avalon.core.entity.AbstractEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限定义类
 * User: faith
 * Date: 13-7-2
 * Time: 下午12:15
 * 主要是抽象类系统权限的定义
 * 扩展spring secuirty的权限
 */
@javax.persistence.Entity
@Table(name = "t_authority")
public class Authority extends AbstractEntity implements GrantedAuthority {

    // 权限名称 用于判断
    private String name;
    //权限显示名称
    private String title;
    private String description;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;


    @ManyToMany
    @JoinTable(name = "t_authories_resources",
            joinColumns = {@JoinColumn(name = "authority_id")},
            inverseJoinColumns = {@JoinColumn(name = "resource_id")})
    private Set<Resource> resources;

    @ManyToMany(mappedBy = "authorities")
    private Set<Role> roles;

    //权限继承
    @ManyToOne(targetEntity = Authority.class)
    private Authority parent;

    @OneToMany(mappedBy = "parent")
    private Set<Authority> children;
    //是否可以使用
    private boolean enable;


    public Authority() {
          this.users = new HashSet<User>();
          this.resources = new HashSet<Resource>();
          this.roles = new HashSet<Role>();
          this.children = new HashSet<Authority>();
          this.enable = true;
    }

    /*============================get and set methods======================================================*/
    @Override
    public String getAuthority() {
        return null;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Authority getParent() {
        return parent;
    }

    public void setParent(Authority parent) {
        this.parent = parent;
    }

    public Set<Authority> getChildren() {
        return children;
    }

    public void setChildren(Set<Authority> children) {
        this.children = children;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
