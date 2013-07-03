package org.fightteam.avalon.dao;

import org.fightteam.avalon.core.entity.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 角色DAO
 * User: faith
 * Date: 13-7-1
 * Time: 下午6:48
 * 继承spring data
 */
public interface RoleDao extends PagingAndSortingRepository<Role,Long>{
}
