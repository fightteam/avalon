package org.fightteam.avalon.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 作者
 *
 * @author excalibur
 * @since 0.0.1
 */
@Entity
@Getter
@Setter
public class Author extends AbstractEntity<Long> {
    private String name;
    private String email;
    private String url;
    private String nationality;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books = new ArrayList<>();
}
