package org.fightteam.avalon.service.impl;

import org.fightteam.avalon.core.entity.domain.Resource;
import org.fightteam.avalon.service.ResourceService;
import org.fightteam.avalon.tools.persistence.service.impl.BasicServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 资源业务逻辑实现
 * User: faith
 * Date: 13-7-3
 * Time: 上午11:01
 * 继承了 BasicServiceImpl 的CRUD、分页与排序
 */
@Service
public class ResourceServiceImpl extends BasicServiceImpl<Resource,Long> implements ResourceService {
    @Override
    public void setUp() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
