package org.fightteam.avalon.security.data.models;

import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * RBAC权限模型 角色组
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class RoleGroup extends AbstractEntity<Long> {
    private String name;
    private String title;
    // 用于排序
    private Integer sequence;
    private String description;

    private boolean enable = true;
    // 本角色组的父类
    @ManyToOne
    private RoleGroup parent;
    // 本角色组的子类
    @OneToMany(mappedBy = "parent")
    private List<RoleGroup> children = new ArrayList<>();
    // 本角色组的角色
    @OneToMany(mappedBy = "roleGroup")
    private List<Role> roles = new ArrayList<>();

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

    public RoleGroup getParent() {
        return parent;
    }

    public void setParent(RoleGroup parent) {
        this.parent = parent;
    }

    public List<RoleGroup> getChildren() {
        return children;
    }

    public void setChildren(List<RoleGroup> children) {
        this.children = children;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
