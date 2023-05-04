package com.meetme.meetme.controller;

import com.meetme.meetme.service.GoogleSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(path = "/events")
public class EventController {
    GoogleSearchService googleSearchService;

    @GetMapping
    public ResponseEntity<String> getEvents(@RequestParam(value = "q") String q, @RequestParam(value = "date", required = false) String date) {
        if (date != null) {
            return ResponseEntity.ok(googleSearchService.search(q, date));
        } else {
            return ResponseEntity.ok(googleSearchService.search(q, null));
        }
    }

}
