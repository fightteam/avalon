package org.fightteam.avalon.data;

import org.fightteam.avalon.data.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author excalibur
 * @since 0.0.1
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
