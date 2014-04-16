package org.fightteam.avalon.data;

import org.fightteam.avalon.data.models.Consumer;
import org.fightteam.avalon.security.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author excalibur
 * @since 0.0.1
 */
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

    Consumer findByUsername(@Param("username")String username);

    Consumer findByEmail(@Param("email")String email);
}
