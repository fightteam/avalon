package org.fightteam.avalon.data;

import org.fightteam.avalon.data.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface ResourceRepository extends JpaRepository<Resource, Long> {
}
