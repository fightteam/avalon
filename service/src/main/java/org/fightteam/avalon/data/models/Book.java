package org.fightteam.avalon.data.models;

import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
public class Book extends AbstractEntity<Long> {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
