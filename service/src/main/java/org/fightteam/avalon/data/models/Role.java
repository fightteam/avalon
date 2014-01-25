package org.fightteam.avalon.data.models;

import javax.persistence.Entity;

/**
 * RBAC权限模型 角色
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class Role extends AbstractEntity<Long> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
