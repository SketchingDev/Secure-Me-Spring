package uk.co.sketchingdev.securemespring.website.search;

import org.springframework.stereotype.Component;
import uk.co.sketchingdev.securemespring.website.search.model.Search;
import uk.co.sketchingdev.securemespring.website.search.model.SearchResult;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;

@Component
public class SearchRepository {

    public Collection<SearchResult> find(Search search) {
        return Arrays.asList(
                new SearchResult("SketchingDev", URI.create("http://sketchingdev.co.uk"), "Blog"),
                new SearchResult("@SketchingDev", URI.create("http://twitter.com/SketchingDev"), "Twitter")
        );
    }
}
