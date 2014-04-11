package org.fightteam.avalon.security.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;

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
@Setter
@Getter
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

    @OneToMany(mappedBy = "permissionGroup")
    private List<User> users = new ArrayList<>();
}
