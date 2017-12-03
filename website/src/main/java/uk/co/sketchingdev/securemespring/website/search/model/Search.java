package uk.co.sketchingdev.securemespring.website.search.model;

public class Search {

    private String term;

    public Search() {
    }

    public Search(final String term) {
        this.term = term;
    }

    public void setTerm(final String term) {
        this.term = term;
    }

    public String getTerm() {
        return term;
    }
}
