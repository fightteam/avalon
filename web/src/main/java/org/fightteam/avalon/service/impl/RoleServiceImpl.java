package org.fightteam.avalon.service.impl;

import org.fightteam.avalon.core.entity.domain.Role;
import org.fightteam.avalon.dao.RoleDao;
import org.fightteam.avalon.service.RoleService;
import org.fightteam.avalon.tools.persistence.service.impl.BasicServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色业务逻辑实现
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:59
 * 继承了 BasicServiceImpl 的CRUD、分页与排序
 */
@Service
public class RoleServiceImpl extends BasicServiceImpl<Role,Long> implements RoleService {
    @Override
    public void setUp() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
