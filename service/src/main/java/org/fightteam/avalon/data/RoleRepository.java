package org.fightteam.avalon.data;

import org.fightteam.avalon.data.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
@RestResource(rel = "roles")
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
}
