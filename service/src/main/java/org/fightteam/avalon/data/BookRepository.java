package org.fightteam.avalon.data;

import org.fightteam.avalon.data.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author excalibur
 * @since 0.0.1
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
