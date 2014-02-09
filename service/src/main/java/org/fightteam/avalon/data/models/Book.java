package org.fightteam.avalon.data.models;

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

}
