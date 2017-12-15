package uk.co.sketchingdev.securemespring.website.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import uk.co.sketchingdev.securemespring.website.search.WebsiteJdbcRepository;
import uk.co.sketchingdev.securemespring.website.search.model.Search;
import uk.co.sketchingdev.securemespring.website.search.model.Website;

import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ResultsControllerTest {

    @Mock
    private WebsiteJdbcRepository repository;

    @Mock
    private Search search;

    @Mock
    private Model model;

    @Test
    public void searchCallsFindAllFromRepository() {
        new ResultsController(repository).results(search, model);

        verify(repository).findAll();
    }

    @Test
    public void searchIsAddedToModel() {
        ResultsController controller = new ResultsController(repository);
        controller.results(search, model);

        verify(model).addAttribute(eq("search"), eq(search));
    }

    @Test
    public void resultsAreAddedToModel() {
        Collection<Website> results = Collections.singleton(mock(Website.class));
        when(repository.findAll()).thenReturn(results);

        ResultsController controller = new ResultsController(repository);
        controller.results(search, model);

        verify(model).addAttribute(eq("results"), eq(results));
    }

    @Test
    public void resultsViewIsReturned() {
        String expectedViewName = "results";
        String actualViewName = new ResultsController(repository).results(search, model);

        assertEquals(expectedViewName, actualViewName);
    }
}
