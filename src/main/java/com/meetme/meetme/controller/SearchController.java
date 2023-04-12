package com.meetme.meetme.controller;

import com.meetme.meetme.model.SearchDTO;
import com.meetme.meetme.service.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping
    public String search(Model model) {
        SearchDTO searchDTO = SearchDTO.builder().build();

        model.addAttribute("searchDTO", searchDTO);

        return "search";
    }

    @PostMapping("/save")
    public String saveSearch(@ModelAttribute("searchDTO") SearchDTO searchDTO) {
        searchService.saveNewSearch(searchDTO);
        return "redirect:/search";
    }
}
