package uk.co.sketchingdev.securemespring.website.search;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.sketchingdev.securemespring.website.search.model.Website;

public interface WebsiteJdbcRepository extends JpaRepository<Website, Long> {
}