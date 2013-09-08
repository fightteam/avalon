package org.fightteam.avalon.repositroy;

import org.fightteam.avalon.core.entity.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * 用户dao
 * User: faith
 * Date: 13-7-1
 * Time: 下午6:48
 * 继承自spring data
 */
@RestResource(path = "users")
public interface UserRepository extends PagingAndSortingRepository<User,Long>{
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
