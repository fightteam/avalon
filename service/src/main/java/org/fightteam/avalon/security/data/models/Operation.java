package org.fightteam.avalon.security.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * RBAC权限模型 操作
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Setter
@Getter
public class Operation extends AbstractEntity<Long> {
    private String name;
    private String title;
    private String description;

    private boolean enable = true;
    // 本操作中的权限
    @OneToMany(mappedBy = "operation")
    private List<Permission> permissions = new ArrayList<>();


}