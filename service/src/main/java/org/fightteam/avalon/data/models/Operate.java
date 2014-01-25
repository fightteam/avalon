package org.fightteam.avalon.data.models;

import javax.persistence.Entity;

/**
 * RBAC权限模型 操作
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class Operate extends AbstractEntity<Long> {
    private String name;
}
