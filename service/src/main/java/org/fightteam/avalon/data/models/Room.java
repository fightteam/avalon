package org.fightteam.avalon.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Getter
@Setter
public class Room extends AbstractEntity<Long> {
}
