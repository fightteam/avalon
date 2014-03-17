package org.fightteam.avalon.mgt.service;

import org.fightteam.avalon.mgt.service.bo.UserBO;
import org.fightteam.avalon.mgt.web.vo.MessageVO;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface UserService {

    MessageVO createUser(UserBO userBO);

    /**
     * 根据id获取对象信息
     *
     * @param id
     * @return 业务对象
     */
    UserBO findUser(Long id);
}
