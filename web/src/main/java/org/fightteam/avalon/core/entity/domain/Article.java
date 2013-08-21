package org.fightteam.avalon.core.entity.domain;

import org.fightteam.avalon.core.entity.Entity;

import javax.persistence.Table;

/**
 * 文章
 * User: faith
 * Date: 13-7-2
 * Time: 下午12:22
 * blog中文章定义
 */
@javax.persistence.Entity
@Table(name = "t_article")
public class Article extends Entity<Long>{
    private String title;
    private String content;
    private String url;




     /*=============================get and set methods==============================================*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
