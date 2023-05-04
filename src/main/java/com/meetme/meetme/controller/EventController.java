package com.meetme.meetme.controller;

import com.meetme.meetme.service.GoogleSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/events")
public class EventController {
    GoogleSearchService googleSearchService;

    @GetMapping
    public ResponseEntity<String> getEvents(@RequestParam(value = "g") String q, @RequestParam(value = "date", required = false) String date) {
        if (date != null) {
            return ResponseEntity.ok(googleSearchService.search(q, date));
        } else {
            return ResponseEntity.ok(googleSearchService.search(q, null));
        }
    }

}
