package uk.co.sketchingdev.securemespring.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.sketchingdev.securemespring.website.search.WebsiteJdbcRepository;
import uk.co.sketchingdev.securemespring.website.search.model.Search;

@Controller
@RequestMapping("/results")
public class ResultsController {

    private final WebsiteJdbcRepository searchRepository;

    @Autowired
    public ResultsController(WebsiteJdbcRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @GetMapping
    public String results(@ModelAttribute final Search search, Model model) {

        model.addAttribute("search", search);
        model.addAttribute("results", searchRepository.findAll());

        return "results";
    }
}