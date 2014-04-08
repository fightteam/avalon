package org.fightteam.avalon.security.data;

import org.fightteam.avalon.security.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);
}
