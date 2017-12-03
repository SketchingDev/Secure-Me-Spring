package uk.co.sketchingdev.securemespring.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.sketchingdev.securemespring.website.search.SearchRepository;
import uk.co.sketchingdev.securemespring.website.search.model.Search;

@Controller
@RequestMapping("/results")
public class ResultsController {

    private final SearchRepository searchRepository;

    @Autowired
    public ResultsController(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @GetMapping
    public String results(@ModelAttribute final Search search, Model model) {

        model.addAttribute("search", search);
        model.addAttribute("results", searchRepository.find(search));

        return "results";
    }
}