package org.fightteam.avalon.security.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * RBAC权限模型 资源
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Setter
@Getter
public class Resource extends AbstractEntity<Long> {

    private String name;
    private String title;
    private String description;
    private boolean enable = true;
    // 本资源的类型
    @Enumerated
    private ResourceType resourceType;

    // 本资源中的权限
    @ManyToMany(mappedBy = "resources")
    private List<Permission> permissions = new ArrayList<>();



}
