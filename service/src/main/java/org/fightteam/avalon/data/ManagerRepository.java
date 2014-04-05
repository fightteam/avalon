package org.fightteam.avalon.data;

import org.fightteam.avalon.data.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
