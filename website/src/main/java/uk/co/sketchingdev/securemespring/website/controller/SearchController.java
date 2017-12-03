package uk.co.sketchingdev.securemespring.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uk.co.sketchingdev.securemespring.website.search.model.Search;

@Controller
@RequestMapping("/")
public class SearchController {

    @RequestMapping
    public String home(Model model) {

        model.addAttribute("search", new Search(""));
        return "search";
    }
}