package org.fightteam.avalon.data;

import org.fightteam.avalon.data.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author excalibur
 * @since 0.0.1
 */
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
