package org.fightteam.avalon.data.models;

import javax.persistence.Entity;

/**
 * RBAC权限模型 角色组
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class RoleGroup extends AbstractEntity<Long> {
    private String name;
}
