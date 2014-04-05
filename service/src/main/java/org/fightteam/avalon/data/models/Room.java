package org.fightteam.avalon.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;

/**
 * 书堂
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Getter
@Setter
public class Room extends AbstractEntity<Long> {

    private String name;
    private String password;
    @Enumerated
    private Type type;

    public enum Type{
        DEFAULT, MESSAGE, AUDIO, VIDEO
    }
}
