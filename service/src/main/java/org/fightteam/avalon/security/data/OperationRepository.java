package org.fightteam.avalon.security.data;

import org.fightteam.avalon.security.data.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * 操作
 *
 * @author faith
 * @since 0.0.1
 */
public interface OperationRepository extends JpaRepository<Operation, Long> {

    Operation findByTitle(@Param("title")String title);

    Operation findByName(@Param("name")String name);
}
