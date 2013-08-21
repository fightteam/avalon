package org.fightteam.avalon.service.impl;

import org.fightteam.avalon.core.entity.domain.Authority;
import org.fightteam.avalon.service.AuthorityService;
import org.fightteam.avalon.tools.persistence.service.impl.BasicServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 权限业务逻辑实现
 * User: faith
 * Date: 13-7-3
 * Time: 上午11:02
 * 继承了 BasicServiceImpl 的CRUD、分页与排序
 */
@Service
public class AuthorityServiceImpl extends BasicServiceImpl<Authority,Long> implements AuthorityService {
    @Override
    public void setUp() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
