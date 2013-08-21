package org.fightteam.avalon.repositroy;

import org.fightteam.avalon.core.entity.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 角色DAO
 * User: faith
 * Date: 13-7-1
 * Time: 下午6:48
 * 继承spring data
 */
public interface RoleRepository extends PagingAndSortingRepository<Role,Long>{
}
