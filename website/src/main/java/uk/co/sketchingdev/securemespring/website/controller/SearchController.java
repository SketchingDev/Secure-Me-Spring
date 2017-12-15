package uk.co.sketchingdev.securemespring.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.sketchingdev.securemespring.website.search.model.Search;

@Controller
@RequestMapping("/")
public class SearchController {

    private final String defaultSearch;

    @Autowired
    public SearchController(@Value("${search.default}") String defaultSearch) {
        this.defaultSearch = defaultSearch;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("search", new Search(defaultSearch));
        return "search";
    }
}