package org.fightteam.avalon.core.entity.domain;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.avalon.core.entity.AbstractEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 权限定义类
 *
 * 主要是抽象类系统权限的定义
 * 扩展spring secuirty的权限
 *
 * @author excalibur
 * @since 0.0.1
 */
@javax.persistence.Entity
@Table(name = "t_authority")
@Getter
@Setter
public class Authority extends AbstractEntity<Long> {

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


}
