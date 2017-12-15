package uk.co.sketchingdev.securemespring.website.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import uk.co.sketchingdev.securemespring.website.search.model.Search;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {

    @Mock
    private Model model;

    @Test
    public void defaultSearchValuePassedToModel() {
        final String defaultSearch = "Test";

        new SearchController(defaultSearch).home(model);

        ArgumentCaptor<Search> argument = ArgumentCaptor.forClass(Search.class);
        verify(model).addAttribute(eq("search"), argument.capture());
        assertEquals(defaultSearch, argument.getValue().getTerm());
    }

    @Test
    public void searchViewIsReturned() {
        String expectedViewName = "search";
        String actualViewName = new SearchController("").home(model);

        assertEquals(expectedViewName, actualViewName);
    }
}
