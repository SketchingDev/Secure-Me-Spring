package uk.co.sketchingdev.securemespring.website.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uk.co.sketchingdev.securemespring.website.search.model.Search;
import uk.co.sketchingdev.securemespring.website.search.model.Website;

import java.net.URI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;


// TODO SQL Injection
@Repository
public class WebsiteJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Website findById(long id) {
        return jdbcTemplate.queryForObject("select * from website where id=?", new Object[] { id },
                BeanPropertyRowMapper.newInstance(Website.class));
    }

    public Collection<Website> findAll(Search search) {
        return jdbcTemplate.query("select * from website", new WebsiteRowMapper());
    }

    class WebsiteRowMapper implements RowMapper<Website> {
        @Override
        public Website mapRow(ResultSet rs, int rowNum) throws SQLException {
            Website website = new Website();
            website.setId(rs.getLong("id"));
            website.setTitle(rs.getString("title"));
            website.setUri(URI.create(rs.getString("uri")));
            website.setDescription(rs.getString("description"));
            return website;
        }

    }
}
