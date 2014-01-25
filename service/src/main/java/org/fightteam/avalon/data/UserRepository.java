package org.fightteam.avalon.data;

import org.fightteam.avalon.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@RestResource(rel = "users")
public interface UserRepository extends JpaRepository<User, Long> {
}
