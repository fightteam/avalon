package org.fightteam.avalon.security.data;

import org.fightteam.avalon.security.data.models.RoleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Long> {

    RoleGroup findByName(@Param("name")String name);
}
