package org.fightteam.avalon.security.data;


import org.fightteam.avalon.security.data.models.PermissionGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface PermissionGroupRepository extends JpaRepository<PermissionGroup, Long> {
}
