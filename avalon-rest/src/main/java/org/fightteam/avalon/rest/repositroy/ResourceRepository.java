package org.fightteam.avalon.rest.repositroy;

import org.fightteam.avalon.core.entity.domain.Resource;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 资源dao
 *
 * 继承spring data
 *
 * @author excalibur
 * @since 0.0.1
 */
public interface ResourceRepository extends PagingAndSortingRepository<Resource,Long> {
}
