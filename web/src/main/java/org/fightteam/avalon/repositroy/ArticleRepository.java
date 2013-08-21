package org.fightteam.avalon.repositroy;

import org.fightteam.avalon.core.entity.domain.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 文章Dao
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:24
 * 继承Spring data
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article,Long> {
}
