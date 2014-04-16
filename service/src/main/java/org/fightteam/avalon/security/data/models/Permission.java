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
 * RBAC权限模型 权限
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Getter
@Setter
public class Permission extends AbstractEntity<Long> {
    private String name;
    private String definition;
    private String title;
    private String description;
    private boolean enable = true;
    // 本权限中的用户
    @ManyToMany(mappedBy = "permissions")
    private List<User> users = new ArrayList<>();
    // 本权限中的角色
    @ManyToMany(mappedBy = "permissions")
    private List<Role> roles = new ArrayList<>();
    // 本权限所属权限组
    @ManyToOne
    private PermissionGroup permissionGroup;

    // 本权限的资源 n-n
    @ManyToMany
    private List<Resource> resources = new ArrayList<>();

    // 本权限的操作 0-n
    @ManyToOne
    private Operation operation;


}
