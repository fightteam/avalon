package org.fightteam.avalon.core.entity.domain;

import org.fightteam.avalon.core.entity.Entity;

import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * 系统资源
 * User: faith
 * Date: 13-7-1
 * Time: 下午6:00
 * 权限依赖于资源产生
 */
@javax.persistence.Entity
@Table(name = "t_resource")
public class Resource extends Entity<Long>{
    //资源名称
    private String name;
    //资源显示的名称
    private String title;
    //资源路径
    private String path;
    //资源类型
    private ResourceType type;
    //资源描述
    private String description;
    //资源状态
    private boolean enable;
    @ManyToMany(mappedBy = "resources")
    private Set<Authority> authorities;

    /**
     * 初始化对象属性
     */
    public Resource() {
           this.authorities = new HashSet<Authority>();
           this.type = ResourceType.URL;
           this.enable = true;
    }


    /*=============================get and set methods==============================================*/

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

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
