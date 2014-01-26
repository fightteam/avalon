package org.fightteam.avalon.data.models;

import javax.persistence.Entity;

/**
 * 分类
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class Category extends AbstractEntity<Long>{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
