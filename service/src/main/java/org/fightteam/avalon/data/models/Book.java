package org.fightteam.avalon.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * 图书
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Getter
@Setter
public class Book extends AbstractEntity<Long> {
    private String title;
    private String ISBN;
    @ManyToMany
    private List<Author> authors = new ArrayList<>();
    @ManyToOne
    private Publisher publisher;
    private DateTime publicationYear;
    @Enumerated
    private Status status;
    @ManyToMany(mappedBy = "books")
    private List<Consumer> readers = new ArrayList<>();
    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    public enum Status{
        UNAVAILABLE, AVAILABLE, FORBID
    }
}
