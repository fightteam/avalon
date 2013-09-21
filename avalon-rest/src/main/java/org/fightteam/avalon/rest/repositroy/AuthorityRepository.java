package org.fightteam.avalon.rest.repositroy;

import org.fightteam.avalon.core.entity.domain.Authority;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * 权限Dao
 *
 * 继承Spring data实现
 *
 * @author excalibur
 * @since 0.0.1
 */
public interface AuthorityRepository extends PagingAndSortingRepository<Authority,Long> {
}
