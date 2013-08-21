package org.fightteam.avalon.service;

import org.fightteam.avalon.core.entity.domain.Role;
import org.fightteam.avalon.tools.persistence.service.BasicService;

/**
 * 角色业务逻辑接口
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:46
 * 继承了BasicService 的CRUD、分页与排序
 */
public interface RoleService extends BasicService<Role,Long> {
}
