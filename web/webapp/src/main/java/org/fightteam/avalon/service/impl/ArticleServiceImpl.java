package org.fightteam.avalon.service.impl;

import org.fightteam.avalon.core.entity.domain.Article;
import org.fightteam.avalon.service.ArticleService;
import org.fightteam.avalon.tools.persistence.service.impl.BasicServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 文章业务逻辑实现
 * User: faith
 * Date: 13-7-3
 * Time: 上午11:05
 * 继承了 BasicServiceImpl 的CRUD、分页与排序
 */
@Service
public class ArticleServiceImpl extends BasicServiceImpl<Article,Long> implements ArticleService {
    @Override
    public void setUp() {

    }
}
