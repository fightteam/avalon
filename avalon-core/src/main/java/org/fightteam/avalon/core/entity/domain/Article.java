package org.fightteam.avalon.core.entity.domain;

import lombok.Getter;
import lombok.Setter;
import org.fightteam.avalon.core.entity.AbstractEntity;

import javax.persistence.Table;

/**
 * 文章
 *
 * blog中文章定义
 *
 * @author excalibur
 * @since 0.0.1
 */
@javax.persistence.Entity
@Table(name = "t_article")
@Getter
@Setter
public class Article extends AbstractEntity<Long> {
    private String title;
    private String content;
    private String url;





}
