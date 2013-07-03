package org.fightteam.avalon.service;

import org.fightteam.avalon.core.entity.domain.Authority;
import org.fightteam.avalon.tools.persistence.service.BasicService;

/**
 * 权限业务逻辑接口
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:46
 * 继承了BasicService 的CRUD、分页与排序
 */
public interface AuthorityService extends BasicService<Authority,Long> {
}
