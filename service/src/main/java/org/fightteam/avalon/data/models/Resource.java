package org.fightteam.avalon.data.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * RBAC权限模型 资源
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class Resource extends AbstractEntity<Long> {
    private String name;
    private String title;
    // 用于记录权限的路径
    private String path;
    @Enumerated
    private ResourceType type;
    private String description;

    private boolean hasAuthority = false;
    private boolean enable = true;
    // 本资源的类型
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    // 本资源中的权限
    @ManyToMany(mappedBy = "resources")
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasAuthority() {
        return hasAuthority;
    }

    public void setHasAuthority(boolean hasAuthority) {
        this.hasAuthority = hasAuthority;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
