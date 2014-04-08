package org.fightteam.avalon.security.data;

import org.fightteam.avalon.security.data.models.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * [description]
 *
 * @author faith
 * @since 0.0.1
 */
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    Resource findByTitle(String title);
}
