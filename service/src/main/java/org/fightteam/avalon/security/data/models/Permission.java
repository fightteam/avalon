package org.fightteam.avalon.security.data.models;


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
public class Permission extends AbstractEntity<Long> {
    private String name;
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

    // 本权限的资源
    @ManyToOne
    private Resource resource;

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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public PermissionGroup getPermissionGroup() {
        return permissionGroup;
    }

    public void setPermissionGroup(PermissionGroup permissionGroup) {
        this.permissionGroup = permissionGroup;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
