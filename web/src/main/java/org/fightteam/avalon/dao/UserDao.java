package org.fightteam.avalon.dao;

import org.fightteam.avalon.core.entity.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 用户dao
 * User: faith
 * Date: 13-7-1
 * Time: 下午6:48
 * 继承自spring data
 */
public interface UserDao extends PagingAndSortingRepository<User,Long>{
    /**
     * 根据帐号查找用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 根据email查找用户
     * @param email
     * @return
     */
    public User findByEmail(String email);
}
