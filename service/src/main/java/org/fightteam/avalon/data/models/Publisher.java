package org.fightteam.avalon.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 出版社
 *
 * @author excalibur
 * @since 0.0.1
 */
@Entity
@Getter
@Setter
public class Publisher extends AbstractEntity<Long> {
    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books = new ArrayList<>();
}
