package org.fightteam.avalon.rest.repositroy;

import org.fightteam.avalon.core.entity.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 角色DAO
 *
 * 继承spring data
 *
 * @author excalibur
 * @since 0.0.1
 */
public interface RoleRepository extends PagingAndSortingRepository<Role,Long>{
}
