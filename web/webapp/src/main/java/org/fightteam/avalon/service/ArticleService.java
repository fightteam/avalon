package org.fightteam.avalon.service;

import org.fightteam.avalon.core.entity.domain.Article;
import org.fightteam.avalon.tools.persistence.service.BasicService;

/**
 * 文章业务逻辑接口
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:54
 * 继承了BasicService 的CRUD、分页与排序
 */
public interface ArticleService extends BasicService<Article,Long> {
}
