package org.fightteam.avalon.dao;

import org.fightteam.avalon.core.entity.domain.Resource;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 资源dao
 * User: faith
 * Date: 13-7-1
 * Time: 下午6:50
 * 继承spring data
 */
public interface ResourceDao extends PagingAndSortingRepository<Resource,Long> {
}
