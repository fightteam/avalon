package org.fightteam.avalon.rest.repositroy;

import org.fightteam.avalon.core.entity.domain.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 文章Dao
 *
 * 继承Spring data
 *
 * @author excalibur
 * @since 0.0.1
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article,Long> {
}
