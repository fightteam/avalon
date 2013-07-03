package org.fightteam.avalon.service.impl;

import org.fightteam.avalon.core.entity.domain.User;
import org.fightteam.avalon.dao.UserDao;
import org.fightteam.avalon.service.UserService;
import org.fightteam.avalon.tools.persistence.service.impl.BasicServiceImpl;
import org.springframework.stereotype.Service;

/**
 * User业务逻辑实现
 * User: faith
 * Date: 13-7-3
 * Time: 上午10:28
 * 继承了 BasicServiceImpl 的CRUD、分页与排序
 */
@Service
public class UserServiceImpl extends BasicServiceImpl<UserDao,User,Long> implements UserService {
}
