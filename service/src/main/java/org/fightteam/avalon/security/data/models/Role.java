package org.fightteam.avalon.security.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * RBAC权限模型 角色
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Setter
@Getter
public class Role extends AbstractEntity<Long> {
    // 用于系统使用
    private String name;
    // 用于呈现
    private String title;
    private String definition;
    private String description;

    private boolean enable = true;
    // 角色中的用户
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
    // 本角色的权限
    @ManyToMany
    private List<Permission> permissions = new ArrayList<>();

    // 本角色所属角色组
    @ManyToOne
    private RoleGroup roleGroup;


}
