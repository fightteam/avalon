package org.fightteam.avalon.data;

import org.fightteam.avalon.data.models.RoleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@RestResource(rel = "roleGroups")
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Long> {
}
