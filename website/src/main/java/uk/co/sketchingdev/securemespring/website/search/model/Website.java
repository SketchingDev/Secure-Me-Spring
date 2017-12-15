package uk.co.sketchingdev.securemespring.website.search.model;

import java.net.URI;
import java.net.URL;

public class Website {

    private String title;

    private URI uri;

    private String description;

    public Website() {
    }

    public Website(final String title, final URI url, final String description) {
        this.title = title;
        this.uri = url;
        this.description = description;
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
