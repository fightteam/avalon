package org.fightteam.avalon.data;

import org.fightteam.avalon.data.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author excalibur
 * @since 0.0.1
 */
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
}
