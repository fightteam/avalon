package org.fightteam.avalon.data.models;

import javax.persistence.Entity;

/**
 * RBAC权限模型 权限组
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class PermissionGroup extends AbstractEntity<Long> {
    private String name;
}
