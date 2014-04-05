package org.fightteam.avalon.data.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.core.json.JsonDateSerializer;
import org.fightteam.join.dao.entity.AbstractEntity;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 消息
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Getter
@Setter
public class Message extends AbstractEntity<Long> {

    @ManyToOne
    private Consumer sender;

    private String content;

    @ManyToMany
    private List<Consumer> recipients = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = JsonDateSerializer.class)
    private DateTime sendTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @JsonSerialize(using = JsonDateSerializer.class)
    private DateTime receiveTime;

}
