package uk.co.sketchingdev.securemespring.website.search;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.co.sketchingdev.securemespring.website.search.model.Website;

import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

// TODO SQL Injection
@Repository
public class WebsiteJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public WebsiteJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Collection<Website> findAll() {
        return jdbcTemplate.query("select * from website", new WebsiteRowMapper());
    }

    public void insert(Website website) {
        jdbcTemplate.update("INSERT INTO website (title, description, uri) VALUES (?, ?, ?)",
                website.getTitle(),
                website.getDescription(),
                website.getUri()
        );
    }

    class WebsiteRowMapper implements RowMapper<Website> {
        @Override
        public Website mapRow(ResultSet rs, int rowNum) throws SQLException {
            Website website = new Website();
            website.setTitle(rs.getString("title"));
            website.setUri(URI.create(rs.getString("uri")));
            website.setDescription(rs.getString("description"));
            return website;
        }

    }
}
