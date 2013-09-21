package org.fightteam.avalon.rest.repositroy;

import org.fightteam.avalon.core.entity.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * 用户dao
 *
 * 继承自spring data
 *
 * @author excalibur
 * @since 0.0.1
 */
public interface UserRepository extends PagingAndSortingRepository<User,Long>{
    /**
     * 根据帐号查找用户信息
     * @param username
     * @return
     */
    public User findByUsername(@Param("username") String username);

    /**
     * 根据email查找用户
     * @param email
     * @return
     */
    public User findByEmail(@Param("email") String email);


}
