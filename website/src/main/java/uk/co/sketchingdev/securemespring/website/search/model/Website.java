package uk.co.sketchingdev.securemespring.website.search.model;

import javax.persistence.*;
import java.net.URI;

@Entity
@Table(name = "website")
public class Website {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private URI uri;

    public Website() {
    }

    public Website(final String title, final String description, final URI url) {
        this.title = title;
        this.description = description;
        this.uri = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setUri(final URI uri) {
        this.uri = uri;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public URI getUri() {
        return uri;
    }

    public String getDescription() {
        return description;
    }
}
