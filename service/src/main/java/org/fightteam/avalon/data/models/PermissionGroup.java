package org.fightteam.avalon.data.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * RBAC权限模型 权限组
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class PermissionGroup extends AbstractEntity<Long> {
    private String name;
    private String title;
    private Integer sequence;
    private String description;
    private boolean enable = true;
    // 本权限组的父类
    @ManyToOne
    private PermissionGroup parent;
    // 本权限组子类
    @OneToMany(mappedBy = "parent")
    private List<PermissionGroup> children = new ArrayList<>();
    // 本权限组中的权限
    @OneToMany(mappedBy = "permissionGroup")
    private List<Permission> permissions = new ArrayList<>();

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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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

    public PermissionGroup getParent() {
        return parent;
    }

    public void setParent(PermissionGroup parent) {
        this.parent = parent;
    }

    public List<PermissionGroup> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionGroup> children) {
        this.children = children;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
