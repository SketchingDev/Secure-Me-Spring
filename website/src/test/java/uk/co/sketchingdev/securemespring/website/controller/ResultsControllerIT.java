package uk.co.sketchingdev.securemespring.website.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import uk.co.sketchingdev.securemespring.website.search.WebsiteJdbcRepository;
import uk.co.sketchingdev.securemespring.website.search.model.Website;

import java.net.URI;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ResultsControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebsiteJdbcRepository websiteJdbcRepository;

    @Test
    public void pageContainsSearchTerm() throws Exception {
        final String title = "Test Title";
        final Website website = new Website(title, "", URI.create("http://example.com"));
        websiteJdbcRepository.save(website);

        final String searchTerm = "Test term";

        mockMvc.perform(get("/results?term={0}", searchTerm))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(modelContainsSearchTerm(searchTerm))
                .andExpect(modelContainsResultWithTitle(title));
    }

    private static ResultMatcher modelContainsSearchTerm(String searchTerm) {
        return model().attribute("search", hasProperty("term", is(searchTerm)));
    }

    private static ResultMatcher modelContainsResultWithTitle(String title) {
        return model().attribute("results", hasItem(hasProperty("title", is(title))));
    }
}
