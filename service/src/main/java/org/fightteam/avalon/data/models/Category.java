package org.fightteam.avalon.data.models;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.join.dao.entity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * 分类
 *
 * @author faith
 * @since 0.0.1
 */
@Entity
@Getter
@Setter
public class Category extends AbstractEntity<Long> {
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books = new ArrayList<>();
}
