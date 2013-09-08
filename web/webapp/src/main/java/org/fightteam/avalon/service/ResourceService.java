package org.fightteam.avalon.service;

import org.fightteam.avalon.core.entity.domain.Resource;
import org.fightteam.avalon.tools.persistence.service.BasicService;

/**
 * 资源业务逻辑接口
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:47
 * 继承了BasicService 的CRUD、分页与排序
 */
public interface ResourceService extends BasicService<Resource,Long> {
}
