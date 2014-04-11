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
 * RBAC权限模型 角色组
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Setter
@Getter
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


    @OneToMany(mappedBy = "roleGroup")
    private List<User> users = new ArrayList<>();
}
